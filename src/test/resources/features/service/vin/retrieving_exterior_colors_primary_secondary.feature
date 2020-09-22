Feature: Retrieve a vehicle by vin and verify the exterior color data for paints. This includes genericDesc, description and primary or secondary paint.

  Scenario Outline: Validate exterior color data for primary or secondary paint returned by vds for a vin.
    Given user wants to retrieve vin information for '<vin>'
    When user calls vds for vin
    Then user should see '<genericDesc>', '<description>' and '<primary>' in exterior color in service response for '<styleId>'
    Examples:
      | vin               | genericDesc | description               | primary | styleId                                                                             |
      | 2C3CDXHG8GH133269 | Blue        | B5 Blue Pearlcoat         | true    | 378128                                                                              |
      | 2C3CDXHG8GH133269 | Silver      | Billet Clearcoat          | true    | 378128                                                                              |
      | 2C3CDXHG8GH133269 | White       | Bright White Clearcoat    | true    | 378128                                                                              |
      | 2C3CDXHG8GH133269 | Orange      | Go Mango                  | true    | 378128                                                                              |
      | 2C3CDXHG8GH133269 | Gray        | Granite Pearlcoat         | true    | 378128                                                                              |
      | 2C3CDXHG8GH133269 | Off-white   | Ivory Tri-Coat Pearl      | true    | 378128                                                                              |
      | 2C3CDXHG8GH133269 | Blue        | Jazz Blue Pearlcoat       | true    | 378128                                                                              |
      | 2C3CDXHG8GH133269 | Gray        | Maximum Steel Metallic CC | true    | 378128                                                                              |
      | 2C3CDXHG8GH133269 | Black       | Pitch Black Clearcoat     | true    | 378128                                                                              |
      | 2C3CDXHG8GH133269 | Purple      | Plum Crazy Pearlcoat      | true    | 378128                                                                              |
      | 2C3CDXHG8GH133269 | Red         | Redline Red Tricoat Pearl | true    | 378128                                                                              |
      | 2C3CDXHG8GH133269 | Red         | Torred Clearcoat          | true    | 378128                                                                              |
      | 1FT7W2BT4KEC16729 | Black       | Agate Black Metallic      | true    | 398652,398653,398654,398655,398656,398657,398662,398663,398664,398665,398666,398667 |
      | 1FT7W2BT4KEC16729 | Yellow      | Yellow                    | true    | 398652,398653,398662,398663                                                         |
      | 1FT7W2BT4KEC16729 | Green       | Silver Spruce             | true    | 398653,398654,398656,398657,398663,398664,398666,398667                             |
      | 1FT7W2BT4KEC16729 | Yellow      | School Bus Yellow         | true    | 398652,398653,398662,398663                                                         |
      | 1FT7W2BT4KEC16729 | Gray        | Stone Gray Metallic       | true    | 398652,398653,398654,398655,398657,398662,398663,398664,398665,398667               |
      | 1FT7W2BT4KEC16729 | Red         | Magma Red Metallic        | true    | 398653,398654,398655,398656,398657,398663,398664,398665,398666,398667               |
      | 1FT7W2BT4KEC16729 | Red         | Vermillion Red            | true    | 398652,398653,398662,398663                                                         |
      | 1FT7W2BT4KEC16729 | Green       | Green                     | true    | 398652,398653,398662,398663                                                         |
      | 1FT7W2BT4KEC16729 | Gray        | Magnetic Metallic         | true    | 398652,398653,398654,398656,398662,398663,398664,398666                             |
      | 1FT7W2BT4KEC16729 | Orange      | Orange                    | true    | 398652,398653,398662,398663                                                         |
      | 1FT7W2BT4KEC16729 | Blue        | Blue Jeans Metallic       | true    | 398652,398653,398654,398655,398656,398662,398663,398664,398665,398666               |
      | 1FT7W2BT4KEC16729 | Red         | Race Red                  | true    | 398652,398653,398654,398662,398663,398664                                           |
      | 1FT7W2BT4KEC16729 | Red         | Ruby Red Met Tinted CC    | true    | 398653,398654,398655,398656,398657,398663,398664,398665,398666,398667               |
      | 1FT7W2BT4KEC16729 | White       | White Platinum Met TC     | true    | 398654,398655,398656,398657,398663,398665,398666,398667               |
      | 1FT7W2BT4KEC16729 | Black       | Agate Black Metallic      | true    | 398652,398653,398654,398655,398656,398657,398662,398663,398664,398665,398666,398667 |
      | 1FT7W2BT4KEC16729 | Silver      | Ingot Silver Metallic     | true    | 398652,398653,398654,398656,398662,398663,398664,398666                             |
      | 1FT7W2BT4KEC16729 | Green       | Green Gem                 | true    | 398652,398653,398662,398663                                                         |
      | 1FT7W2BT4KEC16729 | White       | Oxford White              | true    | 398652,398653,398654,398655,398662,398663,398664,398665                             |
      ##  This vin is for primary color = false
      | 1FT7W2BT4KEC16729 | Gray        | Stone Gray                | false   | 398654,398655,398664,398665                                                         |
      | 1FT7W2BT4KEC16729 | Gray        | Magnetic                  | false   | 398654,398664                                                                       |


