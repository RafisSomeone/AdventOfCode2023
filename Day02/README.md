# 🎄 Advent of Code 2023 - Day 2: Cube Conundrum 🎄

## Overview

Welcome to Day 2 of Advent of Code 2023, titled "Cube Conundrum". 

## ✨ Challenge Descriptions

### 🎁 Part One: Possible Games with Limited Cubes
- **Task**: Determine which games are possible with a specific number of cubes (12 red, 13 green, and 14 blue).
- **Method**: Analyze each game to see if it can be played with the given cube limitations.
- **Example**:
  - **Game 1**:
    - Round 1: Shows 4 red, 3 blue.
    - Round 2: Shows 1 red, 6 blue, 2 green.
    - Round 3: Shows 2 green.
    - This game is possible within the cube limits.
  - **Game 3 State**:
    - Round 1: Shows 20 red, 8 green, 6 blue.
    - This round alone makes Game 3 impossible, as it exceeds the red cube limit.
- **Goal**: Find the sum of the IDs of the possible games.
- **Solution Result**: 2278

### 🌟 Part Two: Minimum Cubes for Each Game
- **Task**: Calculate the fewest number of cubes of each color needed to make each game possible.
- **Method**: Identify the minimum requirement of cubes for each color in every game.
- **Example**:
  - **Game 1**:
    - Requires at least 4 red (from Round 1), 6 blue (from Round 2), and 2 green (from Round 3).
  - **Game 3**:
    - Requires at least 20 red (from Round 1), 13 green, and 6 blue.
- **Goal**: Sum the power of the minimum sets of cubes for all games.
- **Solution Result**: 67953

## 🛠️ Technologies Used
- I found some Java under my Christmas Tree 🎅
