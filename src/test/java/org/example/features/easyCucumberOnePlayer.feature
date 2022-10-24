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

  @ATest51
  Scenario:Easy Cucumber Acceptance Test Line 51
    Given that the host is initialized
    When Player 1 rolls "Skull, Gold, Gold, Parrot, Parrot, Sword, Sword, Sword"
    And  Player 1 draws a "Captain" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,6,7,8" and re-rolls the rest and gets "Skull, Gold, Gold, Sword, Sword, Sword, Gold, Sword"
    Then Player 1 gets a score of 1200

  @ATest52
  Scenario:Easy Cucumber Acceptance Test Line 52
    Given that the host is initialized
    When Player 1 rolls "Skull, Monkey, Monkey, Parrot, Parrot, Sword, Sword, Sword"
    And  Player 1 draws a "Gold" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,4,5,6,7,8" and re-rolls the rest and gets "Skull, Parrot, Parrot, Sword, Sword, Sword, Skull, Sword"
    And Player 1 keeps dice "1,4,5,6,7,8" and re-rolls the rest and gets "Skull, Sword, Sword, Sword, Skull, Sword, Sword, Monkey"
    Then Player 1 gets a score of 600

  @ATest54
  Scenario:Easy Cucumber Acceptance Test Line 54
    Given that the host is initialized
    When Player 1 rolls "Monkey, Monkey, Monkey, Monkey, Monkey, Monkey, Skull, Skull"
    And  Player 1 draws a "Gold" card
    And Player 1 starts there turn
    Then Player 1 gets a score of 1100

  @ATest55
  Scenario:Easy Cucumber Acceptance Test Line 55
    Given that the host is initialized
    When Player 1 rolls "Parrot, Parrot, Parrot, Parrot, Parrot, Parrot, Parrot, Skull"
    And  Player 1 draws a "Gold" card
    And Player 1 starts there turn
    Then Player 1 gets a score of 2100

  @ATest56
  Scenario:Easy Cucumber Acceptance Test Line 56
    Given that the host is initialized
    When Player 1 rolls "Gold, Gold, Gold, Gold, Gold, Gold, Gold, Gold"
    And  Player 1 draws a "Gold" card
    And Player 1 starts there turn
    Then Player 1 gets a score of 5400

  @ATest57
  Scenario:Easy Cucumber Acceptance Test Line 57
    Given that the host is initialized
    When Player 1 rolls "Gold, Gold, Gold, Gold, Gold, Gold, Gold, Gold"
    And  Player 1 draws a "Diamond" card
    And Player 1 starts there turn
    Then Player 1 gets a score of 5400

  @ATest58
  Scenario:Easy Cucumber Acceptance Test Line 58
    Given that the host is initialized
    When Player 1 rolls "Sword, Sword, Sword, Sword, Sword, Sword, Sword, Sword"
    And  Player 1 draws a "Captain" card
    And Player 1 starts there turn
    Then Player 1 gets a score of 9000

  @ATest59
  Scenario:Easy Cucumber Acceptance Test Line 59
    Given that the host is initialized
    When Player 1 rolls "Monkey, Monkey, Monkey, Monkey, Monkey, Monkey, Sword, Sword"
    And  Player 1 draws a "Gold" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,4,5,6" and re-rolls the rest and gets "Monkey, Monkey, Monkey, Monkey, Monkey, Monkey, Monkey, Monkey"
    Then Player 1 gets a score of 4600

  @ATest60
  Scenario:Easy Cucumber Acceptance Test Line 60
    Given that the host is initialized
    When Player 1 rolls "Monkey, Monkey, Skulls, Skulls, Sword, Sword, Parrot, Parrot"
    And  Player 1 draws a "Diamond" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,4,5,6" and re-rolls the rest and gets "Monkey, Monkey, Skulls, Skulls, Sword, Sword, Diamond, Diamond"
    Then Player 1 gets a score of 400

  @ATest61
  Scenario:Easy Cucumber Acceptance Test Line 61
    Given that the host is initialized
    When Player 1 rolls "Monkey, Monkey, Skulls, Skulls, Sword, Sword, Diamond, Parrot"
    And  Player 1 draws a "Gold" card
    And Player 1 starts there turn
    And Player 1 keeps dice "3,4,5,6,7,8" and re-rolls the rest and gets "Skulls, Skulls, Sword, Sword, Diamond, Parrot, Diamond, Diamond"
    Then Player 1 gets a score of 500

  @ATest62
  Scenario:Easy Cucumber Acceptance Test Line 62
    Given that the host is initialized
    When Player 1 rolls "Skulls, Gold, Gold, Monkey, Parrot, Sword, Sword, Sword"
    And  Player 1 draws a "Gold" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,4,5" and re-rolls the rest and gets "Skulls, Gold, Gold, Monkey, Parrot, Gold, Monkey, Parrot"
    Then Player 1 gets a score of 600

  @ATest63
  Scenario:Easy Cucumber Acceptance Test Line 63
    Given that the host is initialized
    When Player 1 rolls "Skulls, Gold, Gold, Monkey, Parrot, Sword, Sword, Sword"
    And  Player 1 draws a "Diamond" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,4,5" and re-rolls the rest and gets "Skulls, Gold, Gold, Monkey, Parrot, Gold, Monkey, Parrot"
    Then Player 1 gets a score of 500

  @ATest64
  Scenario:Easy Cucumber Acceptance Test Line 64
    Given that the host is initialized
    When Player 1 rolls "Monkey, Monkey, Monkey, Monkey, Gold, Gold, Skulls, Skulls"
    And  Player 1 draws a "Gold" card
    And Player 1 starts there turn
    Then Player 1 gets a score of 600

  @ATest69
  Scenario:Easy Cucumber Acceptance Test Line 69
    Given that the host is initialized
    When Player 1 rolls "Diamond, Diamond, Sword, Monkey, Gold, Parrot, Parrot, Parrot"
    And  Player 1 draws a "Sorceress" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,4,5" and re-rolls the rest and gets "Diamond, Diamond, Sword, Monkey, Gold, Skulls, Monkey, Monkey"
    And Player 1 keeps dice "1,2,3,4,5,7,8" and re-rolls the rest and gets "Diamond, Diamond, Sword, Monkey, Gold, Monkey, Monkey, Monkey"
    Then Player 1 gets a score of 500

  @ATest70
  Scenario:Easy Cucumber Acceptance Test Line 70
    Given that the host is initialized
    When Player 1 rolls "Skulls, Skulls, Skulls, Parrot, Parrot, Parrot, Sword, Sword"
    And  Player 1 draws a "Sorceress" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,4,5,6,7,8" and re-rolls the rest and gets "Skulls, Skulls, Parrot, Parrot, Parrot, Sword, Sword, Parrot"
    And Player 1 keeps dice "1,2,3,4,5,8" and re-rolls the rest and gets "Skulls, Skulls, Parrot, Parrot, Parrot, Parrot, Parrot, Parrot"
    Then Player 1 gets a score of 1000

  @ATest71
  Scenario:Easy Cucumber Acceptance Test Line 71
    Given that the host is initialized
    When Player 1 rolls "Skulls, Parrot, Parrot, Parrot, Parrot, Monkey, Monkey, Monkey"
    And  Player 1 draws a "Sorceress" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,4,5" and re-rolls the rest and gets "Skulls, Parrot, Parrot, Parrot, Parrot, Skull, Parrot, Parrot"
    And Player 1 keeps dice "1,2,3,4,5,7,8" and re-rolls the rest and gets "Skulls, Parrot, Parrot, Parrot, Parrot, Parrot, Parrot, Parrot"
    Then Player 1 gets a score of 2000

  @ATest74
  Scenario:Easy Cucumber Acceptance Test Line 74
    Given that the host is initialized
    When Player 1 rolls "Monkey, Monkey, Monkey, Parrot, Parrot, Parrot, Skulls, Gold"
    And  Player 1 draws a "MonkeyBusiness" card
    And Player 1 starts there turn
    Then Player 1 gets a score of 1100

  @ATest75
  Scenario:Easy Cucumber Acceptance Test Line 75
    Given that the host is initialized
    When Player 1 rolls "Monkey, Monkey, Parrot, Parrot, Sword, Sword, Gold, Gold"
    And  Player 1 draws a "MonkeyBusiness" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,4,7,8" and re-rolls the rest and gets "Monkey, Monkey, Parrot, Parrot, Gold, Gold, Monkey, Parrot"
    Then Player 1 gets a score of 1700

  @ATest76
  Scenario:Easy Cucumber Acceptance Test Line 76
    Given that the host is initialized
    When Player 1 rolls "Skulls, Skulls, Skulls, Monkey, Monkey, Monkey, Parrot, Parrot"
    And  Player 1 draws a "MonkeyBusiness" card
    And Player 1 starts there turn
    Then Player 1 dies and gets a score of 0

  @ATest79
  Scenario:Easy Cucumber Acceptance Test Line 79
    Given that the host is initialized
    When Player 1 rolls "Parrot, Parrot, Parrot, Sword, Sword, Diamond, Diamond, Gold"
    And  Player 1 draws a "TreasureChest" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,6,7,8" and re-rolls the rest and gets "Parrot, Parrot, Parrot, Diamond, Diamond, Gold, Parrot, Parrot"
    And Player 1 keeps dice "1,2,3,7,8" and re-rolls the rest and gets "Parrot, Parrot, Parrot, Parrot, Parrot, Skulls, Gold, Parrot"
    Then Player 1 gets a score of 1100

  @ATest84
  Scenario:Easy Cucumber Acceptance Test Line 84
    Given that the host is initialized
    When Player 1 rolls "Skulls, Skulls, Parrot, Parrot, Parrot, Gold, Gold, Gold"
    And  Player 1 draws a "TreasureChest" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,6,7,8" and re-rolls the rest and gets "Skulls, Skulls, Gold, Gold, Gold, Diamond, Diamond, Gold"
    And Player 1 keeps dice "1,2,3,4,5,8" and re-rolls the rest and gets "Skulls, Skulls, Gold, Gold, Gold, Gold, Gold, Skulls"
    Then Player 1 dies and gets a score of 600

  @ATest89
  Scenario:Easy Cucumber Acceptance Test Line 89
    Given that the host is initialized
    When Player 1 rolls "Monkey, Monkey, Monkey, Sword, Sword, Sword, Diamond, Parrot"
    And  Player 1 draws a "Gold" card
    And Player 1 starts there turn
    Then Player 1 gets a score of 400

  @ATest90
  Scenario:Easy Cucumber Acceptance Test Line 90
    Given that the host is initialized
    When Player 1 rolls "Monkey, Monkey, Monkey, Sword, Sword, Sword, Gold, Gold"
    And  Player 1 draws a "Captain" card
    And Player 1 starts there turn
    Then Player 1 gets a score of 1800

  @ATest91
  Scenario:Easy Cucumber Acceptance Test Line 91
    Given that the host is initialized
    When Player 1 rolls "Monkey, Monkey, Monkey, Sword, Sword, Sword, Sword, Diamond"
    And  Player 1 draws a "Gold" card
    And Player 1 starts there turn
    Then Player 1 gets a score of 1000
