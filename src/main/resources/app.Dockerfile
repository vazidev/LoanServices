-name: Loan services
init: |
mvn clean package install
command: |
- setup.sh
java -jar target/spring-LonaServices-1.0.0-SNAPSHOT.jar


ports:
    - port: 4200
        onOpen: open-browser