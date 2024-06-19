FROM openjdk:17-oracle

WORKDIR /opt/ebank-business

COPY ./target/ebank-business.jar /opt/ebank-business

EXPOSE 9001

ENTRYPOINT ["java","-jar","/opt/ebank-business/ebank-business.jar"]

CMD []