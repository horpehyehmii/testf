FROM jenkins/jenkins:alpine3.20-jdk21
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
COPY scripts/* /usr/share/jenkins/ref/init.groovy.d
RUN curl "https://awscli.amazonaws.com/awscli-exe-linux-aarch64.zip" -o "awscliv2.zip" && \
    unzip awscliv2.zip && ./aws/install && aws --version
