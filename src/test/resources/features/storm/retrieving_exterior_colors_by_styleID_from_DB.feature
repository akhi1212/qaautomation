Feature: Query the DB directly by styleID and verify the exterior color data for paints, stripes, and roof colors. This includes code, color name, genericName, primary or secondary paint, rgbValue, and type.

  #Feature for styleID that have ECC 0084 Striping. StyleID 407134 also has ECC 0087 Roof Type but roof color logic is not implemented yet (option MXS).
  Scenario Outline: Validate RVE scripts's exterior stripe value by DB query
    Given Actor wants to get a valid connection to the database
    When Actor wants to retrieve exterior color data from the DB for '<styleId>'
    Then Actor should see the 'code' as '<code>', 'name' as '<name>', 'genericName' as '<genericName>', 'primary' as '<primary>', 'rgbValue' as '<rgbValue>', 'type' as '<type>' in the query response

    Examples:
      | styleId | code | name                                | genericName                         | primary | rgbValue    | type |
      | 407323  | PFQ  | F8 Green                            | Green                               | true    | 74,76,52    | 1    |
      | 407323  | PCA  | Frostbite                           | Blue                                | true    | 20,64,80    | 1    |
      | 407323  | PVP  | Go Mango                            | Orange                              | true    | 228,26,34   | 1    |
      | 407323  | PAU  | Granite Pearlcoat                   | Gray                                | true    | 74,70,69    | 1    |
      | 407323  | PCD  | Hellraisin                          | Red                                 | true    | 80,32,42    | 1    |
      | 407323  | PBM  | Indigo Blue                         | Blue                                | true    | 38,85,155   | 1    |
      | 407323  | PRV  | Octane Red Pearlcoat                | Red                                 | true    | 49,1,13     | 1    |
      | 407323  | PX8  | Pitch Black Clearcoat               | Black                               | true    | 14,14,15    | 1    |
      | 407323  | PEC  | Sinamon Stick                       | Brown                               | true    | 50,34,18    | 1    |
      | 407323  | PAE  | Smoke Show                          | Gray                                | true    | 104,104,104 | 1    |
      | 407323  | PR3  | Torred Clearcoat                    | Red                                 | true    | 139,16,39   | 1    |
      | 407323  | PSE  | Triple Nickel Clearcoat             | Silver                              | true    | 142,141,139 | 1    |
      | 407323  | PW7  | White Knuckle Clearcoat             | White                               | true    | 228,233,229 | 1    |
      | 407323  | M93  | Dual Stripe - Blue                  | Dual Stripe - Blue                  |         |             | 3    |
      | 407323  | M96  | Dual Stripe - Carbon                | Dual Stripe - Carbon                |         |             | 3    |
      | 407323  | M2S  | Dual Stripe - Gunmetal              | Dual Stripe - Gunmetal              |         |             | 3    |
      | 407323  | M98  | Dual Stripe - Red                   | Dual Stripe - Red                   |         |             | 3    |
      | 407323  | M94  | Dual Stripe - Silver                | Dual Stripe - Silver                |         |             | 3    |
      | 407134  | PQD  | B5 Blue Pearl                       | Blue                                | true    | 18,121,163  | 1    |
      | 407134  | PCA  | Frostbite                           | Blue                                | true    | 20,64,80    | 1    |
      | 407134  | PFQ  | F8 Green                            | Green                               | true    | 74,76,52    | 1    |
      | 407134  | PVP  | Go Mango                            | Orange                              | true    | 228,26,34   | 1    |
      | 407134  | PAU  | Granite Pearlcoat                   | Gray                                | true    | 74,70,69    | 1    |
      | 407134  | PCD  | Hellraisin                          | Red                                 | true    | 80,32,42    | 1    |
      | 407134  | PBM  | Indigo Blue                         | Blue                                | true    | 38,85,155   | 1    |
      | 407134  | PRV  | Octane Red Pearlcoat                | Red                                 | true    | 49,1,13     | 1    |
      | 407134  | PX8  | Pitch Black Clearcoat               | Black                               | true    | 14,14,15    | 1    |
      | 407134  | PEC  | Sinamon Stick                       | Brown                               | true    | 50,34,18    | 1    |
      | 407134  | PAE  | Smoke Show                          | Gray                                | true    | 104,104,104 | 1    |
      | 407134  | PR3  | Torred Clearcoat                    | Red                                 | true    | 139,16,39   | 1    |
      | 407134  | PSE  | Triple Nickel Clearcoat             | Silver                              | true    | 142,141,139 | 1    |
      | 407134  | PW7  | White Knuckle Clearcoat             | White                               | true    | 228,233,229 | 1    |
      | 407134  | M96  | Dual Carbon Stripes                 | Dual Carbon Stripes                 |         |             | 3    |
      | 407134  | MEH  | Satin Black Hood/Roof/Trunk/Spoiler | Satin Black Hood/Roof/Trunk/Spoiler |         |             | 3    |

  #Feature for styleID that have ECC 0085 Stripe Color. Both styleID also have ECC 0087 Roof Type but roof color logic is not implemented yet (option MXS)
  Scenario Outline: Validate RVE scripts's exterior stripe value by DB query
    Given Actor wants to get a valid connection to the database
    When Actor wants to retrieve exterior color data from the DB for '<styleId>'
    Then Actor should see the 'code' as '<code>', 'name' as '<name>', 'genericName' as '<genericName>', 'primary' as '<primary>', 'rgbValue' as '<rgbValue>', 'type' as '<type>' in the query response

    Examples:
      | styleId | code | name                      | genericName           | primary | rgbValue    | type |
      | 378137  | PQD  | B5 Blue Pearlcoat         | Blue                  | true    | 18,121,163  | 1    |
      | 378137  | PSC  | Billet Clearcoat          | Silver                | true    | 130,134,136 | 1    |
      | 378137  | PW7  | Bright White Clearcoat    | White                 | true    | 229,233,229 | 1    |
      | 378137  | PVP  | Go Mango                  | Orange                | true    | 228,26,34   | 1    |
      | 378137  | PAU  | Granite Pearlcoat         | Gray                  | true    | 53,54,56    | 1    |
      | 378137  | PWD  | Ivory Tri-Coat Pearl      | Off-white             | true    | 200,199,192 | 1    |
      | 378137  | PBX  | Jazz Blue Pearlcoat       | Blue                  | true    | 3,13,27     | 1    |
      | 378137  | PAR  | Maximum Steel Metallic CC | Gray                  | true    | 29,33,34    | 1    |
            #09/01/2020-Scripts are returning short desc. PAR long desc = Maximum Steel Metallic Clearcoat
      | 378137  | PX8  | Pitch Black Clearcoat     | Black                 | true    | 11,11,11    | 1    |
      | 378137  | PHG  | Plum Crazy Pearlcoat      | Purple                | true    | 57,52,115   | 1    |
      | 378137  | PRY  | Redline Red Tricoat Pearl | Red                   | true    | 106,0,18    | 1    |
      | 378137  | PR3  | Torred Clearcoat          | Red                   | true    | 139,16,39   | 1    |
      | 378137  | M96  | Dual Carbon Stripes       | Dual Carbon Stripes   |         |             | 3    |
      | 393217  | PQD  | B5 Blue Pearlcoat         | Blue                  | true    | 18,121,163  | 1    |
      | 393217  | PSC  | Billet Clearcoat          | Silver                | true    | 130,134,136 | 1    |
      | 393217  | PDN  | Destroyer Gray Clearcoat  | Gray                  | true    | 93,93,93    | 1    |
      | 393217  | PFQ  | F8 Green                  | Green                 | true    | 63,85,45    | 1    |
      | 393217  | PVP  | Go Mango                  | Orange                | true    | 228,26,34   | 1    |
      | 393217  | PAU  | Granite Pearlcoat         | Gray                  | true    | 74,70,69    | 1    |
      | 393217  | PBM  | Indigo Blue               | Blue                  | true    | 38,85,155   | 1    |
      | 393217  | PAR  | Maximum Steel Metallic CC | Gray                  | true    | 29,33,34    | 1    |
            #09/01/2020-Scripts are returning short desc. PAR long desc = Maximum Steel Metallic Clearcoat
      | 393217  | PRV  | Octane Red Pearlcoat      | Red                   | true    | 49,1,13     | 1    |
      | 393217  | PX8  | Pitch Black Clearcoat     | Black                 | true    | 14,14,15    | 1    |
      | 393217  | PRY  | Redline Red Tricoat Pearl | Red                   | true    | 106,0,18    | 1    |
      | 393217  | PHG  | Plum Crazy Pearlcoat      | Purple                | true    | 57,52,115   | 1    |
      | 393217  | PR3  | Torred Clearcoat          | Red                   | true    | 139,16,39   | 1    |
      | 393217  | PW7  | White Knuckle Clearcoat   | White                 | true    | 229,233,229 | 1    |
      | 393217  | PY4  | Yellow Jacket Clearcoat   | Yellow                | true    | 206,167,0   | 1    |
      | 393217  | M96  | Dual Carbon Stripes       | Dual Carbon Stripes   |         |             | 3    |
      | 393217  | M2S  | Dual Gunmetal Stripes     | Dual Gunmetal Stripes |         |             | 3    |

  #Feature for styleID that have ECC 0070 Exterior Mirrors w/ICC HMA02.
  Scenario Outline: Validate RVE scripts's exterior stripe value by DB query
    Given Actor wants to get a valid connection to the database
    When Actor wants to retrieve exterior color data from the DB for '<styleId>'
    Then Actor should see the 'code' as '<code>', 'name' as '<name>', 'genericName' as '<genericName>', 'primary' as '<primary>', 'rgbValue' as '<rgbValue>', 'type' as '<type>' in the query response

    Examples:
      | styleId | code | name                              | genericName                       | primary | rgbValue    | type |
      | 399428  | 850  | Pepper White                      | White                             | true    | 235,225,203 | 1    |
      | 399428  | 851  | Chili Red                         | Red                               | true    | 146,7,14    | 1    |
      | 399428  | A62  | White Silver Metallic             | White                             | true    | 176,174,170 | 1    |
      | 399428  | A94  | Midnight Black Metallic           | Black                             | true    | 0,0,0       | 1    |
      | 399428  | B22  | British Racing Green Met          | Green                             | true    | 9,29,17     | 1    |
            #09/01/2020-Scripts are returning short desc. B22 long desc = British Racing Green Metallic
      | 399428  | B58  | Thunder Grey Metallic             | Gray                              | true    | 27,28,29    | 1    |
      | 399428  | B62  | Starlight Blue Metallic           | Blue                              | true    | 33,52,108   | 1    |
      | 399428  | B71  | Moonwalk Grey Metallic            | Gray                              | true    | 104,104,102 | 1    |
      | 399428  | B86  | Electric Blue Metallic            | Blue                              | true    | 0,168,216   | 1    |
      | 399428  | C19  | JCW Rebel Green                   | Green                             | true    | 0,32,11     | 1    |
            #09/01/2020-Scripts are returning short desc. C19 long desc = John Cooper Works Rebel Green
      | 399428  | C1B  | Solaris Orange Metallic           | Orange                            | true    | 164,61,37   | 1    |
      | 399428  | C1C  | Emerald Grey Metallic             | Gray                              | true    | 152,152,139 | 1    |
      | 399428  | C24  | Lapisluxury Blue                  | Blue                              | true    | 17,17,21    | 1    |
            #09/01/2020-Scripts are returning short desc. C24 long desc = MINI Yours Lapisluxury Blue
      | 399428  | C2K  | Melting Silver Metallic           | Silver                            | true    | 112,111,107 | 1    |
      | 399428  | 382  | White Roof and Mirror Caps        | White Roof and Mirror Caps        |         |             | 2    |
      | 399428  | 383  | Black Roof and Mirror Caps        | Black Roof and Mirror Caps        |         |             | 2    |
      | 399428  | 3A3  | Chili Red Roof and Mirror Caps    | Chili Red Roof and Mirror Caps    |         |             | 2    |
      | 399428  | 3AF  | Melting Silver Roof and Mirror Caps | Melting Silver Roof and Mirror Caps |     |             | 2    |
      | 394651  | 851  | Chili Red                         | Red                               | true    | 146,7,14    | 1    |
      | 394651  | A94  | Midnight Black Metallic           | Black                             | true    | 0,0,0       | 1    |
      | 394651  | B15  | Light White                       | White                             | true    | 230,224,225 | 1    |
      | 394651  | B22  | British Racing Green Met          | Green                             | true    | 9,29,17     | 1    |
            #09/01/2020-Scripts are returning short desc. B22 long desc = British Racing Green Metallic
      | 394651  | B71  | Moonwalk Grey Metallic            | Gray                              | true    | 104,104,102 | 1    |
      | 394651  | C1V  | Chestnut                          | Brown                             | true    | 107,45,17   | 1    |
      | 394651  | C24  | Lapisluxury Blue                  | Blue                              | true    | 17,17,21    | 1    |
            #09/01/2020-Scripts are returning short desc. C24 long desc = MINI Yours Lapisluxury Blue
      | 394651  | C2K  | Melting Silver Metallic           | Silver                            | true    | 112,111,107 | 1    |
      | 394651  | C2M  | Island Blue Metallic              | Blue                              | true    | 22,92,144   | 1    |
      | 394651  | 382  | White Roof and Mirror Caps        | White Roof and Mirror Caps        |         |             | 2    |
      | 394651  | 383  | Black Roof and Mirror Caps        | Black Roof and Mirror Caps        |         |             | 2    |

  #Feature for styleID that have ECC 0088 Roof Color.
  Scenario Outline: Validate RVE scripts's exterior stripe value by DB query
    Given Actor wants to get a valid connection to the database
    When Actor wants to retrieve exterior color data from the DB for '<styleId>'
    Then Actor should see the 'code' as '<code>', 'name' as '<name>', 'genericName' as '<genericName>', 'primary' as '<primary>', 'rgbValue' as '<rgbValue>', 'type' as '<type>' in the query response

    Examples:
      | styleId | code | name                     | genericName              | primary | rgbValue    | type |
      | 398629  | D1   | Stone Gray Metallic      | Gray                     | true    | 96,81,70    | 1    |
      | 398629  | FT   | Blue Metallic            | Blue                     | true    | 37,55,67    | 1    |
      | 398629  | J7   | Magnetic Metallic        | Gray                     | true    | 69,71,68    | 1    |
      | 398629  | R3   | Burgundy Velvet Met TC   | Red                      | true    | 48,2,5      | 1    |
            #09/01/2020-Scripts are returning short desc. R3 long desc = Burgundy Velvet Metallic Tinted Clearcoat
      | 398629  | RR   | Ruby Red Met Tinted CC   | Red                      | true    | 87,5,18     | 1    |
            #09/01/2020-Scripts are returning short desc. RR long desc = Ruby Red Metallic Tinted Clearcoat
      | 398629  | UG   | White Platinum Met TC    | White                    | true    | 210,206,206 | 1    |
            #09/01/2020-Scripts are returning short desc. UG long desc = White Platinum Metallic Tri-Coat
      | 398629  | UM   | Agate Black              | Black                    | true    | 10,10,12    | 1    |
      | 398629  | UX   | Ingot Silver Metallic    | Silver                   | true    | 161,161,161 | 1    |
      | 398629  | YZ   | Oxford White             | White                    | true    | 231,231,229 | 1    |
      | 398629  | 87M  | Monochromatic Roof       | Monochromatic Roof       |         |             | 2    |
      | 398629  | 87B  | Agate Black Painted Roof | Agate Black Painted Roof |         |             | 2    |

  #Feature for styleID that have both primary and secondary paint.
  Scenario Outline: Validate RVE scripts's exterior stripe value by DB query
    Given Actor wants to get a valid connection to the database
    When Actor wants to retrieve exterior color data from the DB for '<styleId>'
    Then Actor should see the 'code' as '<code>', 'name' as '<name>', 'genericName' as '<genericName>', 'primary' as '<primary>', 'rgbValue' as '<rgbValue>', 'type' as '<type>' in the query response

    Examples:
      | styleId | code | name                   | genericName | primary | rgbValue    | type |
      | 398638  | UM   | Agate Black Metallic   | Black       | true    | 10,10,12    | 1    |
      | 398638  | N1   | Blue Jeans Metallic    | Blue        | true    | 17,41,59    | 1    |
      | 398638  | UX   | Ingot Silver Metallic  | Silver      | true    | 161,161,161 | 1    |
      | 398638  | E2   | Magma Red Metallic     | Red         | true    | 46,33,28    | 1    |
      | 398638  | J7   | Magnetic Metallic      | Gray        | true    | 69,71,68    | 1    |
      | 398638  | Z1   | Oxford White           | White       | true    | 247,247,245 | 1    |
      | 398638  | PQ   | Race Red               | Red         | true    | 172,32,53   | 1    |
      | 398638  | RR   | Ruby Red Met Tinted CC | Red         | true    | 87,5,18     | 1    |
            #09/01/2020-Scripts are returning short desc. RR long desc = Ruby Red Metallic Tinted Clearcoat
      | 398638  | BN   | Silver Spruce          | Green       | true    | 162,169,165 | 1    |
      | 398638  | D1   | Stone Gray Metallic    | Gray        | true    | 96,81,70    | 1    |
      | 398638  | UG   | White Platinum Met TC  | White       | true    | 210,206,206 | 1    |
            #09/01/2020-Scripts are returning short desc. UG long desc = White Platinum Metallic Tri-Coat
      | 398638  | D1   | Stone Gray             | Gray        | false   | 96,81,70    | 1    |
      | 398638  | J7   | Magnetic               | Gray        | false   | 69,71,68    | 1    |