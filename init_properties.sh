#!/bin/sh
set -e
server=$1
welcomePage=$2

echo "init properties ..."

echo "server:$1"
echo "welcomePage:$2"

echo >env/default/init.properties
echo "server=$1" >>env/default/init.properties
echo "welcomePage=$2" >>env/default/init.properties

echo "init done."

chmod 777 build/test-results/binary/gauge
