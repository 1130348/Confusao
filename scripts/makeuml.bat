REM Vai gerar as imagens relativas aos diagramas de UML em pastas com o nome doc-files
REM O javadoc copia automaticamente essas pastas para a pasta com o resultado do java-doc
java -jar ../lib/plantuml.jar "../src*/**.puml"
REM java -jar ../lib/plantuml.jar "../doc/javadoc-overview.html"

