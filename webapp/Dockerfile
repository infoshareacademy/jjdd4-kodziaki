FROM jboss/wildfly

MAINTAINER "infoShare Academy kodziaki"

COPY target/appPartments.war /opt/jboss/wildfly/standalone/deployments/
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent


COPY src/main/resources/images1 /opt/
CMD ["echo Waiting 5 seconds"]
CMD ["sleep", "5"]
CMD ["echo Starting Wildfly"]
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
