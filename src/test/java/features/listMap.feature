Feature: listMap

  Scenario: list

    Given single List
      | a | b | c | d |

    Given multi line single list
      | a  | b  | c  | d  |
      | a1 | b1 | c1 | d1 |
      | a2 | b2 | c2 | d2 |


    Given list of lists
      | a  | b  | c  | d  |
      | a1 | b1 | c1 | d1 |
      | a2 | b2 | c2 | d2 |

    Given maps
      | a | a1 |
      | b | b1 |
      | c | c1 |
      | d | d1 |

    Given list of maps
      | a  | b  | c  | d  |
      | a1 | b1 | c1 | d1 |
      | a2 | b2 | c2 | d2 |

    Given user name "Admin"
    #data yi en kolay bu yontem ile aliyoruz

