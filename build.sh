#!/usr/bin/env bash

rm nbb-npm-caxa 2>/dev/null >/dev/null

npx caxa@2.1.0 --input . --output nbb-npm-caxa -- \
  "{{caxa}}/node_modules/.bin/nbb" \
  "-cp" "{{caxa}}/src" \
  "-m" "nbb-npm-caxa.core"  