@echo off
echo Starting Services
cd grpcClientApp/target
echo Starting ClientApp...
start "" cmd /c "java -jar grpcClientApp-1.0-jar-with-dependencies.jar && pause"
echo Starting LoggingApp...
cd ../../LoggingApp/target
start "" cmd /c "java -jar LoggingApp-1.0-jar-with-dependencies.jar && pause"
echo running...