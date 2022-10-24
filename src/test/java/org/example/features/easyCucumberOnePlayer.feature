# you can add comments
Feature: Fruits
  You can also add multi-line
  description

  @tag1 @tag2
  Scenario: I eat apple
    Given I have 5 apple
    When I eat 4 apple
    Then I should left 1 apple

  @tag2 @tag3
  Scenario Outline: I eat other fruits
    Given I have <total> apple
    When I eat <eatCount> apple
    Then I should left <leftCount> apple
    Examples:
      | total | eatCount | leftCount |
      | 5     | 4        | 1         |
      | 10    | 5        | 5         |

    @die3Skulls
    Scenario: Die with 3 skulls
      Given that the host is initialized
      When Player 1 rolls "Skull, Skull, Skull, Sword, Sword, Sword, Sword, Sword"
      And  Player 1 draws a "Gold" card
      And Player 1 starts there turn
      Then Player 1 dies and gets a score of 0

  @ATest38
  Scenario:Easy Cucumber Acceptance Test Line 38
    Given that the host is initialized
    When Player 1 rolls "Skull, Parrot, Parrot, Parrot, Parrot, Sword, Sword, Sword"
    And  Player 1 draws a "Gold" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,4,5" and re-rolls the rest and gets "Skull, Parrot, Parrot, Parrot, Parrot, Skull, Skull, Sword"
    Then Player 1 dies and gets a score of 0

  @ATest39
  Scenario:Easy Cucumber Acceptance Test Line 39
    Given that the host is initialized
    When Player 1 rolls "Skull, Skull, Parrot, Parrot, Parrot, Parrot, Sword, Sword"
    And  Player 1 draws a "Gold" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,4,5,6" and re-rolls the rest and gets "Skull, Skull, Parrot, Parrot, Parrot, Parrot, Skull, Sword"
    Then Player 1 dies and gets a score of 0

  @ATest40
  Scenario:Easy Cucumber Acceptance Test Line 40
    Given that the host is initialized
    When Player 1 rolls "Skull, Parrot, Parrot, Parrot, Parrot, Sword, Sword, Sword"
    And  Player 1 draws a "Gold" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,4,5" and re-rolls the rest and gets "Skull, Parrot, Parrot, Parrot, Parrot, Skull, Monkey, Monkey"
    And Player 1 keeps dice "1,2,3,4,5,6" and re-rolls the rest and gets "Skull, Parrot, Parrot, Parrot, Parrot, Skull, Skull, Monkey"
    Then Player 1 dies and gets a score of 0

  @ATest42
  Scenario:Easy Cucumber Acceptance Test Line 42
    Given that the host is initialized
    When Player 1 rolls "Skull, Parrot, Parrot, Sword, Sword, Sword, Gold, Gold"
    And  Player 1 draws a "Gold" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,4,5,6,7,8" and re-rolls the rest and gets "Skull, Sword, Sword, Sword, Gold, Gold, Gold, Gold"
    And Player 1 keeps dice "1,5,6,7,8" and re-rolls the rest and gets "Skull, Gold, Gold, Gold, Gold, Gold, Gold, Gold"
    Then Player 1 gets a score of 4800

  @ATest42
  Scenario:Easy Cucumber :Acceptance Test Line 45
    Given that the host is initialized
    When Player 1 rolls "Monkey, Monkey, Skull, Skull, Sword, Sword, Parrot, Parrot"
    And  Player 1 draws a "Gold" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,4,5,6" and re-rolls the rest and gets "Monkey, Monkey, Skull, Skull, Sword, Sword, Sword, Monkey"
    Then Player 1 gets a score of 300

  @ATest46
  Scenario:Easy Cucumber  Acceptance Test Line 46
    Given that the host is initialized
    When Player 1 rolls "Monkey, Monkey, Monkey, Sword, Sword, Sword, Skull, Skull"
    And  Player 1 draws a "Gold" card
    And Player 1 starts there turn
    Then Player 1 gets a score of 300

  @ATest47
  Scenario:Easy Cucumber Acceptance Test Line 47
    Given that the host is initialized
    When Player 1 rolls "Diamond, Diamond, Diamond, Skull, Skull, Monkey, Sword, Parrot"
    And  Player 1 draws a "Gold" card
    And Player 1 starts there turn
    Then Player 1 gets a score of 500

  @ATest48
  Scenario:Easy Cucumber Acceptance Test Line 48
    Given that the host is initialized
    When Player 1 rolls "Gold, Gold, Gold, Gold, Skull, Skull, Sword, Sword"
    And  Player 1 draws a "Diamond" card
    And Player 1 starts there turn
    Then Player 1 gets a score of 700

  @ATest49
  Scenario:Easy Cucumber Acceptance Test Line 49
    Given that the host is initialized
    When Player 1 rolls "Sword, Sword, Sword, Parrot, Parrot, Parrot, Parrot, Skull"
    And  Player 1 draws a "Gold" card
    And Player 1 starts there turn
    Then Player 1 gets a score of 400

  @ATest50
  Scenario:Easy Cucumber Acceptance Test Line 50
    Given that the host is initialized
    When Player 1 rolls "Skull, Gold, Gold, Parrot, Parrot, Sword, Sword, Sword"
    And  Player 1 draws a "Gold" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,6,7,8" and re-rolls the rest and gets "Skull, Gold, Gold, Sword, Sword, Sword, Gold, Sword"
    Then Player 1 gets a score of 800
