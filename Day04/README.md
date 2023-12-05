# 🎄 Advent of Code 2023 - Day 4: Scratchcards 🎄

## Overview

Welcome to Day 4 of Advent of Code 2023, titled "Scratchcards".

## ✨ Challenge Descriptions

### 🎁 Part One: Calculating Points from Scratchcards
- **Task**: Determine the total points from a pile of scratchcards.
- **Method**: Match numbers on each card with a list of winning numbers, scoring points based on the number of matches.
- **Example**:
  - Card 1: `41 48 83 86 17 | 83 86 6 31 17 9 48 53`
    - Winning numbers: `41, 48, 83, 86, 17`
    - Points for Card 1: `8` (1 for the first match, doubled for each subsequent match)
  - Total points: Sum of points from all cards.
- **Goal**: Find the total points value of the Elf's scratchcards.
- **Solution Result**: 23235

### 🌟 Part Two: Winning More Scratchcards
- **Task**: Calculate the total number of scratchcards won, including copies.
- **Method**: For each card, win copies of subsequent cards equal to the number of matching numbers.
- **Example**:
  - Card 1: `41 48 83 86 17 | 83 86 6 31 17 9 48 53`
    - Wins 4 copies (for 4 matches) of the next four cards.
  - Process continues, including copies of cards.
- **Goal**: Count the total number of scratchcards, including originals and all copies won.
- **Solution Result**: 5920640

## 🛠️ Technologies Used
- I found some Java under my Christmas Tree 🎅

