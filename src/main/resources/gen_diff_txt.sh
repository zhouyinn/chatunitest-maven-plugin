#!/usr/bin/env bash

BASE="custom-hits"
DEFAULT="$BASE/default"
OUTPUT="diff_report.txt"

> "$OUTPUT"

for dir in "$BASE"/*; do
  name=$(basename "$dir")

  if [[ -d "$dir" && "$name" != "default" ]]; then
    if diff -rq "$DEFAULT" "$dir" | grep -q "differ"; then
      echo "===== $name =====" >> "$OUTPUT"
      diff -ru "$DEFAULT" "$dir" >> "$OUTPUT"
      echo -e "\n\n" >> "$OUTPUT"
    fi
  fi
done

echo "Report generated: $OUTPUT"