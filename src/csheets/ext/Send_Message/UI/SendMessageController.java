/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Send_Message.UI;

import csheets.ext.Send_Message.Connection;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DMMCA
 */
public class SendMessageController {
    /** The user interface controller */
	private UIController uiController;
        
        /** User interface panel **/
        private SendMessageSideBar SMMPanel;

        /** ChatUI User Interface **/
        
        private static ChatUI CUI;
        
        private ArrayList<Connection> connections;
        
        private static Connection activeCon  = null;
        
        private static Connection SERVER = null;
        
	/**
	 * Creates a new SendMessage controller.
	 * @param uiController the user interface controller
         * @param uiPanel the user interface panel
	 */
	public SendMessageController(UIController uiController, SendMessageSideBar SMMPanel){
		this.uiController = uiController;
                this.SMMPanel = SMMPanel;
                
                createServer();
                
            
                
	}
        
        public void setChatUI(ChatUI SMB) throws IOException{
            CUI = SMB;  
        }
        
        public static void StartCon() throws IOException{
            activeCon = new Connection(CUI.getSelectedCon(), 3339);
            activeCon.setUI(CUI);
            activeCon.createThreads();
            CUI.getSend().addActionListener(new Act(activeCon,CUI));
        }

    private void createServer() {
        Thread Server = new Thread(){
            @Override
            public void run(){
                try {
                    if(SERVER == null){
                        SERVER = new Connection(3339);
                    }
                SERVER.createThreads();
                SERVER.setUI(CUI);
                CUI.SetConnection(SERVER.getConSocket().getInetAddress().toString().substring(1,SERVER.getConSocket().getInetAddress().toString().length()));
                    
            } catch (IOException ex) {
                
            }
            }
        };
           Server.start();
    }
        
        private static class Act implements ActionListener {

        private Connection f;
        private ChatUI ui;

        public Act(Connection f, ChatUI ui) {
            this.f = f;
            this.ui = ui;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String txt = ui.getTxt().getText();
            try {
                f.SendMessage(txt);
                ui.getTxt().setText("");
            } catch (IOException ex) {
                Logger.getLogger(Connection.class.getName()).
                    log(Level.SEVERE, null, ex);
            }
        }
    }
}
