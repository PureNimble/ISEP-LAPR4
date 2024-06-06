java -cp ./jar/*:h2.jar org.h2.tools.Server \
    -tcp -tcpAllowOthers -tcpPort 2223 \
    -ifNotExists -baseDir /root