Feature: Easy Cucumber Acceptance tests for Multi-player scenarios

  @ATest122
  Scenario:Easy Cucumber Acceptance Test Line 122
    Given that the host is initialized
    When Player 1 rolls "Sword, Sword, Sword, Sword, Sword, Sword, Sword, Skull"
    And  Player 1 draws a "Captain" card
    And Player 1 starts there turn
    Then Player 1 gets a score of 4000
    And All the players scores are displayed

    When Player 2 rolls "Sword, Sword, Sword, Sword, Sword, Sword, Sword, Skull"
    And  Player 2 draws the "Skulls" card with "1 Skulls"
    And Player 2 starts there turn
    Then Player 2 gets a score of 2000
    And All the players scores are displayed

    When Player 3 rolls "Skull, Skull, Skull, Monkey, Monkey, Monkey, Monkey, Monkey"
    And  Player 3 draws a "Gold" card
    And Player 3 starts there turn
    Then Player 3 gets a score of 0
    And All the players scores are displayed
    Then log the game in log file "easyCucumberRow122.txt"


  @ATest126
  Scenario:Easy Cucumber Acceptance Test Line 126
    Given that the host is initialized
    When Player 1 rolls "Sword, Sword, Sword, Sword, Sword, Sword, Sword, Skull"
    And  Player 1 draws a "Captain" card
    And Player 1 starts there turn
    Then Player 1 gets a score of 4000
    And All the players scores are displayed

    When Player 2 rolls "Skull, Skull, Skull, Monkey, Monkey, Monkey, Monkey, Monkey"
    And  Player 2 draws a "Gold" card
    And Player 2 starts there turn
    Then Player 2 gets a score of 0
    And All the players scores are displayed

    When Player 3 rolls "Skull, Skull, Skull, Skull, Skull, Skull, Parrot, Parrot"
    And  Player 3 draws a "Captain" card
    And Player 3 starts there turn
    Then Player 3 exits island of skulls and subtracts -1200 to each other player's score
    And All the players scores are displayed

    When Player 1 rolls "Monkey, Monkey, Monkey, Monkey, Parrot, Parrot, Parrot, Parrot"
    And  Player 1 draws a "Gold" card
    And Player 1 starts there turn
    Then Player 1 gets a score of 1000
    And All the players scores are displayed

    When Player 2 rolls "Skull, Skull, Skull, Monkey, Monkey, Monkey, Monkey, Monkey"
    And  Player 2 draws a "Captain" card
    And Player 2 starts there turn
    Then Player 2 gets a score of 0
    And All the players scores are displayed

    When Player 3 rolls "Skull, Skull, Monkey, Monkey, Monkey, Monkey, Monkey, Monkey"
    And  Player 3 draws the "Skulls" card with "1 Skulls"
    And Player 3 starts there turn
    Then Player 3 gets a score of 0
    And All the players scores are displayed
    Then log the game in log file "easyCucumberRow126.txt"


  @ATest134
  Scenario:Easy Cucumber Acceptance Test Line 134
    Given that the host is initialized
    When Player 1 rolls "Skull, Skull, Skull, Monkey, Monkey, Monkey, Monkey, Monkey"
    And  Player 1 draws a "Gold" card
    And Player 1 starts there turn
    Then Player 1 gets a score of 0
    And All the players scores are displayed

    When Player 2 rolls "Sword, Sword, Sword, Sword, Sword, Sword, Sword, Skull"
    And  Player 2 draws a "Captain" card
    And Player 2 starts there turn
    Then Player 2 gets a score of 4000
    And All the players scores are displayed

    When Player 3 rolls "Skull, Sword, Sword, Sword, Sword, Sword, Sword, Sword"
    And  Player 3 draws the "Skulls" card with "2 Skulls"
    And Player 3 starts there turn
    Then Player 3 gets a score of 0
    And All the players scores are displayed

    When Player 1 rolls "Sword, Sword, Sword, Sword, Sword, Sword, Sword, Sword"
    And  Player 1 draws a "Captain" card
    And Player 1 starts there turn
    Then Player 1 gets a score of 9000
    And All the players scores are displayed

    When Player 2 rolls "Skull, Sword, Sword, Sword, Sword, Sword, Sword, Sword"
    And  Player 2 draws the "Skulls" card with "2 Skulls"
    And Player 2 starts there turn
    Then Player 2 gets a score of 0
    And All the players scores are displayed

    When Player 3 rolls "Skull, Sword, Sword, Sword, Sword, Sword, Sword, Sword"
    And  Player 3 draws the "Skulls" card with "2 Skulls"
    And Player 3 starts there turn
    Then Player 3 gets a score of 0
    And All the players scores are displayed
    Then log the game in log file "easyCucumberRow134.txt"


  @ATest139
  Scenario:Easy Cucumber Acceptance Test Line 139
    Given that the host is initialized
    When Player 1 rolls "Sword, Sword, Sword, Sword, Sword, Sword, Skull, Skull"
    And  Player 1 draws a "Gold" card
    And Player 1 starts there turn
    Then Player 1 gets a score of 1100
    And All the players scores are displayed

    When Player 2 rolls "Skull, Skull, Skull, Skull, Skull, Skull, Skull, Gold"
    And  Player 2 draws a "Gold" card
    And Player 2 starts there turn
    And Player 2 keeps dice "1,2,3,4,5,6" and re-rolls the rest and gets "Skull, Skull, Skull, Skull, Skull, Skull, Parrot, Gold"
    And Player 2 keeps dice "1,2,3,4,5,6" and re-rolls the rest and gets "Skull, Skull, Skull, Skull, Skull, Skull, Skull, Skull"
    Then Player 2 exits island of skulls and subtracts -1300 to each other player's score
    And All the players scores are displayed
    Then log the game in log file "easyCucumberRow139.txt"





