FROM jenkins/jenkins:alpine3.20-jdk21
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
COPY scripts/* /usr/share/jenkins/ref/init.groovy.d
