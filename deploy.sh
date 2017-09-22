#!/bin/sh

set -e

cd now
../now-linux rm ics4 -y --token $NOW_TOKEN
../now-linux --debug --public --force --token  $NOW_TOKEN
../now-linux ls --token $NOW_TOKEN
../now-linux alias  --token $NOW_TOKEN
../now-linux scale ics4-2018.now.sh 1 --token $NOW_TOKEN