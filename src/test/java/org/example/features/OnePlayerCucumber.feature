Feature: Tests for One player and check score

  Scenario: Die with 3 skulls
    Given that the host is initialized
    When I roll "Skull, Skull, Skull, Sword, Sword, Sword, Sword, Sword"
    And  I draw a "Gold" card
    And Player 1 starts there turn
    Then I die and get a score of 0

    Scenario:Acceptance Test Line 38
      Given that the host is initialized
      When I roll "Skull, Parrot, Parrot, Parrot, Parrot, Sword, Sword, Sword"
      And  I draw a "Gold" card
      And Player 1 starts there turn
      And Player 1 keeps dice "1,2,3,4,5" and re-rolls the rest and gets "Skull, Parrot, Parrot, Parrot, Parrot, Skull, Skull, Sword"
      Then I die and get a score of 0

  Scenario:Acceptance Test Line 39
    Given that the host is initialized
    When I roll "Skull, Skull, Parrot, Parrot, Parrot, Parrot, Sword, Sword"
    And  I draw a "Gold" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,4,5,6" and re-rolls the rest and gets "Skull, Skull, Parrot, Parrot, Parrot, Parrot, Skull, Sword"
    Then I die and get a score of 0

  Scenario:Acceptance Test Line 40
    Given that the host is initialized
    When I roll "Skull, Parrot, Parrot, Parrot, Parrot, Sword, Sword, Sword"
    And  I draw a "Gold" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,4,5" and re-rolls the rest and gets "Skull, Parrot, Parrot, Parrot, Parrot, Skull, Monkey, Monkey"
    And Player 1 keeps dice "1,2,3,4,5,6" and re-rolls the rest and gets "Skull, Parrot, Parrot, Parrot, Parrot, Skull, Skull, Monkey"
    Then I die and get a score of 0

  Scenario:Acceptance Test Line 42
    Given that the host is initialized
    When I roll "Skull, Parrot, Parrot, Sword, Sword, Sword, Gold, Gold"
    And  I draw a "Gold" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,4,5,6,7,8" and re-rolls the rest and gets "Skull, Sword, Sword, Sword, Gold, Gold, Gold, Gold"
    And Player 1 keeps dice "1,5,6,7,8" and re-rolls the rest and gets "Skull, Gold, Gold, Gold, Gold, Gold, Gold, Gold"
    Then I get a score of 4800

  Scenario: Acceptance Test Line 44
    Given that the host is initialized
    When I roll "Monkey, Monkey, Parrot, Parrot, Diamond, Diamond, Gold, Gold"
    And  I draw a "Captain" card
    And Player 1 starts there turn
    Then I get a score of 800

  Scenario:Acceptance Test Line 45
    Given that the host is initialized
    When I roll "Monkey, Monkey, Skull, Skull, Sword, Sword, Parrot, Parrot"
    And  I draw a "Gold" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,4,5,6" and re-rolls the rest and gets "Monkey, Monkey, Skull, Skull, Sword, Sword, Sword, Monkey"
    Then I get a score of 300

  Scenario: Acceptance Test Line 46
    Given that the host is initialized
    When I roll "Monkey, Monkey, Monkey, Sword, Sword, Sword, Skull, Skull"
    And  I draw a "Gold" card
    And Player 1 starts there turn
    Then I get a score of 300

  Scenario: Acceptance Test Line 47
    Given that the host is initialized
    When I roll "Diamond, Diamond, Diamond, Skull, Skull, Monkey, Sword, Parrot"
    And  I draw a "Gold" card
    And Player 1 starts there turn
    Then I get a score of 500

  Scenario: Acceptance Test Line 48
    Given that the host is initialized
    When I roll "Gold, Gold, Gold, Gold, Skull, Skull, Sword, Sword"
    And  I draw a "Diamond" card
    And Player 1 starts there turn
    Then I get a score of 700

  Scenario: Acceptance Test Line 49
    Given that the host is initialized
    When I roll "Sword, Sword, Sword, Parrot, Parrot, Parrot, Parrot, Skull"
    And  I draw a "Gold" card
    And Player 1 starts there turn
    Then I get a score of 400

  Scenario: Acceptance Test Line 50
    Given that the host is initialized
    When I roll "Skull, Gold, Gold, Parrot, Parrot, Sword, Sword, Sword"
    And  I draw a "Gold" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,6,7,8" and re-rolls the rest and gets "Skull, Gold, Gold, Sword, Sword, Sword, Gold, Sword"
    Then I get a score of 800

  Scenario: Acceptance Test Line 51
    Given that the host is initialized
    When I roll "Skull, Gold, Gold, Parrot, Parrot, Sword, Sword, Sword"
    And  I draw a "Captain" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,6,7,8" and re-rolls the rest and gets "Skull, Gold, Gold, Sword, Sword, Sword, Gold, Sword"
    Then I get a score of 1200

  Scenario:Acceptance Test Line 52
    Given that the host is initialized
    When I roll "Skull, Monkey, Monkey, Parrot, Parrot, Sword, Sword, Sword"
    And  I draw a "Gold" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,4,5,6,7,8" and re-rolls the rest and gets "Skull, Parrot, Parrot, Sword, Sword, Sword, Skull, Sword"
    And Player 1 keeps dice "1,4,5,6,7,8" and re-rolls the rest and gets "Skull, Sword, Sword, Sword, Skull, Sword, Sword, Monkey"
    Then I get a score of 600

  Scenario: Acceptance Test Line 54
    Given that the host is initialized
    When I roll "Monkey, Monkey, Monkey, Monkey, Monkey, Monkey, Skull, Skull"
    And  I draw a "Gold" card
    And Player 1 starts there turn
    Then I get a score of 1100

  Scenario: Acceptance Test Line 55
    Given that the host is initialized
    When I roll "Parrot, Parrot, Parrot, Parrot, Parrot, Parrot, Parrot, Skull"
    And  I draw a "Gold" card
    And Player 1 starts there turn
    Then I get a score of 2100

  Scenario: Acceptance Test Line 56
    Given that the host is initialized
    When I roll "Gold, Gold, Gold, Gold, Gold, Gold, Gold, Gold"
    And  I draw a "Gold" card
    And Player 1 starts there turn
    Then I get a score of 5400

  Scenario: Acceptance Test Line 57
    Given that the host is initialized
    When I roll "Gold, Gold, Gold, Gold, Gold, Gold, Gold, Gold"
    And  I draw a "Diamond" card
    And Player 1 starts there turn
    Then I get a score of 5400

  Scenario: Acceptance Test Line 58
    Given that the host is initialized
    When I roll "Sword, Sword, Sword, Sword, Sword, Sword, Sword, Sword"
    And  I draw a "Captain" card
    And Player 1 starts there turn
    Then I get a score of 9000

  Scenario: Acceptance Test Line 59
    Given that the host is initialized
    When I roll "Monkey, Monkey, Monkey, Monkey, Monkey, Monkey, Sword, Sword"
    And  I draw a "Gold" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,4,5,6" and re-rolls the rest and gets "Monkey, Monkey, Monkey, Monkey, Monkey, Monkey, Monkey, Monkey"
    Then I get a score of 4600

  Scenario: Acceptance Test Line 60
    Given that the host is initialized
    When I roll "Monkey, Monkey, Skulls, Skulls, Sword, Sword, Parrot, Parrot"
    And  I draw a "Diamond" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,4,5,6" and re-rolls the rest and gets "Monkey, Monkey, Skulls, Skulls, Sword, Sword, Diamond, Diamond"
    Then I get a score of 400

  Scenario: Acceptance Test Line 61
    Given that the host is initialized
    When I roll "Monkey, Monkey, Skulls, Skulls, Sword, Sword, Diamond, Parrot"
    And  I draw a "Gold" card
    And Player 1 starts there turn
    And Player 1 keeps dice "3,4,5,6,7,8" and re-rolls the rest and gets "Skulls, Skulls, Sword, Sword, Diamond, Parrot, Diamond, Diamond"
    Then I get a score of 500

  Scenario: Acceptance Test Line 62
    Given that the host is initialized
    When I roll "Skulls, Gold, Gold, Monkey, Parrot, Sword, Sword, Sword"
    And  I draw a "Gold" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,4,5" and re-rolls the rest and gets "Skulls, Gold, Gold, Monkey, Parrot, Gold, Monkey, Parrot"
    Then I get a score of 600

  Scenario: Acceptance Test Line 63
    Given that the host is initialized
    When I roll "Skulls, Gold, Gold, Monkey, Parrot, Sword, Sword, Sword"
    And  I draw a "Diamond" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,4,5" and re-rolls the rest and gets "Skulls, Gold, Gold, Monkey, Parrot, Gold, Monkey, Parrot"
    Then I get a score of 500

  Scenario: Acceptance Test Line 64
    Given that the host is initialized
    When I roll "Monkey, Monkey, Monkey, Monkey, Gold, Gold, Skulls, Skulls"
    And  I draw a "Gold" card
    And Player 1 starts there turn
    Then I get a score of 600

  Scenario: Acceptance Test Line 69
    Given that the host is initialized
    When I roll "Diamond, Diamond, Sword, Monkey, Gold, Parrot, Parrot, Parrot"
    And  I draw a "Sorceress" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,4,5" and re-rolls the rest and gets "Diamond, Diamond, Sword, Monkey, Gold, Skulls, Monkey, Monkey"
    And Player 1 keeps dice "1,2,3,4,5,7,8" and re-rolls the rest and gets "Diamond, Diamond, Sword, Monkey, Gold, Monkey, Monkey, Monkey"
    Then I get a score of 500

  Scenario: Acceptance Test Line 70
    Given that the host is initialized
    When I roll "Skulls, Skulls, Skulls, Parrot, Parrot, Parrot, Sword, Sword"
    And  I draw a "Sorceress" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,4,5,6,7,8" and re-rolls the rest and gets "Skulls, Skulls, Parrot, Parrot, Parrot, Sword, Sword, Parrot"
    And Player 1 keeps dice "1,2,3,4,5,8" and re-rolls the rest and gets "Skulls, Skulls, Parrot, Parrot, Parrot, Parrot, Parrot, Parrot"
    Then I get a score of 1000

  Scenario: Acceptance Test Line 71
    Given that the host is initialized
    When I roll "Skulls, Parrot, Parrot, Parrot, Parrot, Monkey, Monkey, Monkey"
    And  I draw a "Sorceress" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,4,5" and re-rolls the rest and gets "Skulls, Parrot, Parrot, Parrot, Parrot, Skull, Parrot, Parrot"
    And Player 1 keeps dice "1,2,3,4,5,7,8" and re-rolls the rest and gets "Skulls, Parrot, Parrot, Parrot, Parrot, Parrot, Parrot, Parrot"
    Then I get a score of 2000

  Scenario: Acceptance Test Line 74
    Given that the host is initialized
    When I roll "Monkey, Monkey, Monkey, Parrot, Parrot, Parrot, Skulls, Gold"
    And  I draw a "MonkeyBusiness" card
    And Player 1 starts there turn
    Then I get a score of 1100

  Scenario: Acceptance Test Line 75
    Given that the host is initialized
    When I roll "Monkey, Monkey, Parrot, Parrot, Sword, Sword, Gold, Gold"
    And  I draw a "MonkeyBusiness" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,4,7,8" and re-rolls the rest and gets "Monkey, Monkey, Parrot, Parrot, Gold, Gold, Monkey, Parrot"
    Then I get a score of 1700

  Scenario: Acceptance Test Line 76
    Given that the host is initialized
    When I roll "Skulls, Skulls, Skulls, Monkey, Monkey, Monkey, Parrot, Parrot"
    And  I draw a "MonkeyBusiness" card
    And Player 1 starts there turn
    Then I die and get a score of 0

  Scenario: Acceptance Test Line 79
    Given that the host is initialized
    When I roll "Parrot, Parrot, Parrot, Sword, Sword, Diamond, Diamond, Gold"
    And  I draw a "TreasureChest" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,6,7,8" and re-rolls the rest and gets "Parrot, Parrot, Parrot, Diamond, Diamond, Gold, Parrot, Parrot"
    And Player 1 keeps dice "1,2,3,7,8" and re-rolls the rest and gets "Parrot, Parrot, Parrot, Parrot, Parrot, Skulls, Gold, Parrot"
    Then I get a score of 1100

  Scenario: Acceptance Test Line 84
    Given that the host is initialized
    When I roll "Skulls, Skulls, Parrot, Parrot, Parrot, Gold, Gold, Gold"
    And  I draw a "TreasureChest" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,6,7,8" and re-rolls the rest and gets "Skulls, Skulls, Gold, Gold, Gold, Diamond, Diamond, Gold"
    And Player 1 keeps dice "1,2,3,4,5,8" and re-rolls the rest and gets "Skulls, Skulls, Gold, Gold, Gold, Gold, Gold, Skulls"
    Then I die and get a score of 600

  Scenario: Acceptance Test Line 89
    Given that the host is initialized
    When I roll "Monkey, Monkey, Monkey, Sword, Sword, Sword, Diamond, Parrot"
    And  I draw a "Gold" card
    And Player 1 starts there turn
    Then I get a score of 400

  Scenario: Acceptance Test Line 90
    Given that the host is initialized
    When I roll "Monkey, Monkey, Monkey, Sword, Sword, Sword, Gold, Gold"
    And  I draw a "Captain" card
    And Player 1 starts there turn
    Then I get a score of 1800

  Scenario: Acceptance Test Line 91
    Given that the host is initialized
    When I roll "Monkey, Monkey, Monkey, Sword, Sword, Sword, Sword, Diamond"
    And  I draw a "Gold" card
    And Player 1 starts there turn
    Then I get a score of 1000
