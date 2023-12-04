# 🎄 Advent of Code 2023 - Day 3: Gear Ratios 🎄

## Overview

Welcome to Day 3 of Advent of Code 2023, titled "Gear Ratios".

## ✨ Challenge Descriptions

### 🎁 Part One: Summing Part Numbers
- **Task**: Calculate the sum of all the part numbers in an engine schematic.
- **Method**: Identify numbers adjacent to symbols in the schematic and sum them up.
- **Example**:
  - Schematic Snippet:\
    `467&.114..`\
    `..........` \
    `..35..633.` \
    `.*.......+`
  - Part numbers to sum: `467`, `35`, `633` (excluding `114` as it's not adjacent to a symbol).
- **Goal**: Find the total sum of part numbers.
- **Solution Result**: 536576

### 🌟 Part Two: Calculating Gear Ratios
- **Task**: Determine the gear ratio for each gear in the engine and sum them.
- **Method**: Identify gears as `*` symbols adjacent to exactly two part numbers and multiply these numbers.
- **Example**:
  - Schematic Snippet: \
  `467*..633.`, \
  `...35.....`, \
  `..........`, \
  `.664*598..`
  - Gears: One at `467*` (adjacent to `467` and `35`) and another at `664*` (adjacent to `664` and `598`). 
  - Gear Ratios: `467 * 35` and `664 * 598`.
- **Goal**: Sum of all gear ratios.
- **Solution Result**: 75741499

## 🛠️ Technologies Used
- I found some Java under my Christmas Tree 🎅
