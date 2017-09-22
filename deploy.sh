#!/bin/sh

set -e

cd now
now rm ics4 -y --token $NOW_TOKEN
now --debug --public --force --token  $NOW_TOKEN
now ls --token $NOW_TOKEN
now alias  --token $NOW_TOKEN
now scale ics4-2018.now.sh 1 --token $NOW_TOKEN