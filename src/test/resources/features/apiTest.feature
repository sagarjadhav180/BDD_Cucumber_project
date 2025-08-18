Feature: CRUD operations


  @api_suite
  Scenario Outline: GET call
    Given I make request to "/objects/12" to view objects
    Then I must get response code "200"
    And I must be able to see all the objects
      | id   | name   | Generation   | Price   | Capacity   |
      | <id> | <name> | <Generation> | <Price> | <Capacity> |
    Examples:
      | id | name           | Generation | Price  | Capacity |
      | 12 | Apple iPad Air | 4th        | 419.99 | 64 GB    |

  @api_suite
  Scenario Outline: POST call using data from json file
    Given I make a "POST" request to create machine data using "<JSONFile>"
    Then I must get response code "200"
    And I make request to "/objects/" to view newly created objects
    Then I must get response code "200"
    And I must be able to see newly created object
      | name   | year   | price   | CPU model   | Hard disk size   |
      | <name> | <year> | <price> | <CPU model> | <Hard disk size> |
    Examples:
      | JSONFile          | name                 | year | price   | CPU model     | Hard disk size |
      | appleMacBook.json | Apple MacBook Pro 16 | 2019 | 1849.99 | Intel Core i9 | 1 TB           |

  @api_suite
  Scenario Outline: POST call using data from json file
    Given I make a "POST" request to create machine data using data from excel file for scenario "<scenario>"
    Then I must get response code "200"
    And I make request to "/objects/" to view newly created objects
    Then I must get response code "200"
    And I must be able to see newly created object
      | name   | year   | price   | CPU model   | Hard disk size   |
      | <name> | <year> | <price> | <CPU model> | <Hard disk size> |
    Examples:
      | scenario        | name                 | year | price   | CPU model     | Hard disk size |
      | addMacbookEntry | Apple MacBook Pro 16 | 2020 | 1949.99 | Intel Core i9 | 1 TB           |


  @api_suite
  Scenario Outline: POST call using data from json file
    Given I make a "POST" request to create machine data using "<JSONFile>"
    Then I must get response code "200"
    And I make request to "/objects/" to view newly created objects
    Then I must get response code "200"
    And I must be able to see newly created object using jsonpath
      | name   | year   | price   | CPU model   | Hard disk size   |
      | <name> | <year> | <price> | <CPU model> | <Hard disk size> |
    Examples:
      | JSONFile          | name                 | year | price   | CPU model     | Hard disk size |
      | appleMacBook.json | Apple MacBook Pro 16 | 2019 | 1849.99 | Intel Core i9 | 1 TB           |
