#!/usr/bin/env bash

npx caxa@2.1.0 --input . --output nbb-npm-caxa -- \
  "{{caxa}}/node_modules/.bin/nbb" \
  "-cp" "{{caxa}}/src" \
  "-m" "nbb-npm-caxa.core"  