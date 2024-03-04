echo "Compilacion de JFlex"
java -jar /home/jbravo/Apps/jflex/jflex-1.9.1/lib/jflex-full-1.9.1.jar -d ../src/main/java/com/jbrod/ide_sql/app/analyzer/ lexer.flex

echo "Compilacion de cup"
java -jar /home/jbravo/Apps/cup/cup-20160615/java-cup-11b.jar -parser SqlParser parser.cup
mv SqlParser.java ../src/main/java/com/jbrod/ide_sql/app/analyzer/
mv sym.java ../src/main/java/com/jbrod/ide_sql/app/analyzer/