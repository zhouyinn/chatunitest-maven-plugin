#!/usr/bin/env bash

BASE="custom-hits"
DEFAULT="$BASE/default"
OUTDIR="diff_html"

mkdir -p "$OUTDIR"

for dir in "$BASE"/*; do
  name=$(basename "$dir")

  if [[ -d "$dir" && "$name" != "default" ]]; then
    if diff -rq "$DEFAULT" "$dir" | grep -q "differ"; then
      OUTPUT_FILE="$OUTDIR/$name.html"

      git diff --no-index "$DEFAULT" "$dir" \
        | diff2html -i stdin -s side -F "$OUTPUT_FILE"

      echo "Generated: $OUTPUT_FILE"
    fi
  fi
done