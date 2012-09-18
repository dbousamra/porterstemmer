#!/usr/local/bin/fish
java -Xmx512M -XX:MaxPermSize=128M -jar `dirname $0`/sbt-launch.jar $argv
java -Xmx512M -XX:MaxPermSize=128M -jar (dirname $_)/sbt-launch.jar "$argv" 