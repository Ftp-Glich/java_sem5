@echo off
echo Генерация Javadoc документации...
javadoc -d docs -author -version -encoding UTF-8 -charset UTF-8 *.java
echo Документация сгенерирована в папке 'docs'
echo Откройте docs/index.html для просмотра