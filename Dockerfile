FROM tomcat:8.5.11

#RUN apt-get update && apt-get install -y \nano\&& mkdir -p /usr/local/tomcat/conf
COPY tomcat-users.xml /usr/local/tomcat/conf/
COPY context.xml /usr/local/tomcat/webapps/manager/META-INF/
EXPOSE 8080
ADD target/MVC.war /usr/local/tomcat/webapps/
CMD ["catalina.sh", "run"]
