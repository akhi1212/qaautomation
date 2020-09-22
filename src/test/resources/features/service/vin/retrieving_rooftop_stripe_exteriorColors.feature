Feature: Retrieve a vehicle by vin and verify the exterior color data for Stripes and Roof Top colors are being populated. The specific feature will use a VIN which includes genericDesc, description, rgbValue, type and primary.

  Scenario Outline: Validate Roof Top and Stripe colors returned by vds in exterior colors array
    Given Actor wants to retrieve vin information for '<vin>'
    When Actor calls vds for vin
    Then Actor should see the '<genericDesc>', '<description>', '<rgbValue>', '<type>' and '<primary>' in exterior colors in service response for '<styles>'

  #Feature for VIN that have ECC 0084 Striping.
    # Feature for VIN that have ECC 0070 Exterior Mirrors contains ICC HMA & 0088 in exteriorColor.
    Examples:
      | vin               | genericDesc                 | description                 | rgbValue    | type | primary | styles        |
      | WMWXP5C5XK2H97962 | White                       | Pepper White                | 235,225,203 | 1    | true    | 399426,404459 |
      | WMWXP5C5XK2H97962 | Red                         | Chili Red                   | 146,7,14    | 1    | true    | 399426,404459 |
      | WMWXP5C5XK2H97962 | Blue                        | Lapisluxury Blue            | 17,17,21    | 1    | true    | 399426        |
      | WMWXP5C5XK2H97962 | White                       | White Silver Metallic       | 176,174,170 | 1    | true    | 399426        |
      | WMWXP5C5XK2H97962 | Black                       | Midnight Black Metallic     | 0,0,0       | 1    | true    | 399426,404459 |
      | WMWXP5C5XK2H97962 | Green                       | British Racing Green Met    | 9,29,17     | 1    | true    | 399426,404459 |
      | WMWXP5C5XK2H97962 | Blue                        | Starlight Blue Metallic     | 33,52,108   | 1    | true    | 399426,404459 |
      | WMWXP5C5XK2H97962 | Gray                        | Moonwalk Grey Metallic      | 104,104,102 | 1    | true    | 399426        |
      | WMWXP5C5XK2H97962 | Blue                        | Electric Blue Metallic      | 0,168,216   | 1    | true    | 399426        |
      | WMWXP5C5XK2H97962 | Orange                      | Solaris Orange Metallic     | 164,61,37   | 1    | true    | 399426        |
      | WMWXP5C5XK2H97962 | Gray                        | Emerald Grey Metallic       | 152,152,139 | 1    | true    | 399426        |
      | WMWXP5C5XK2H97962 | Blue                        | Electric Blue Metallic      | 0,168,216   | 1    | true    | 399426        |
      | WMWXP5C5XK2H97962 | Silver                      | Melting Silver Metallic     | 112,111,107 | 1    | true    | 399426,404459 |
      | WMWXP5C5XK2H97962 | White Bonnet Stripes        | White Bonnet Stripes        |             | 3    |         | 399426        |
      | WMWXP5C5XK2H97962 | Black Bonnet Stripes        | Black Bonnet Stripes        |             | 3    |         | 399426        |
      | WMWXP5C5XK2H97962 | White Roof and Mirror Caps  | White Roof and Mirror Caps  |             | 2    |         | 399426,404459 |
      | WMWXP5C5XK2H97962 | Black Roof and Mirror Caps  | Black Roof and Mirror Caps  |             | 2    |         | 399426,404459 |
      | 2C3CDZBT9LH134135 | Gray                        | Smoke Show                  | 104,104,104 | 1    | true    | 407320        |
      | 2C3CDZBT9LH134135 | Gray                        | Granite Pearlcoat           | 74,70,69    | 1    | true    | 407320        |
      | 2C3CDZBT9LH134135 | Blue                        | Indigo Blue                 | 38,85,155   | 1    | true    | 407320        |
      | 2C3CDZBT9LH134135 | Blue                        | Frostbite                   | 20,64,80    | 1    | true    | 407320        |
      | 2C3CDZBT9LH134135 | Red                         | Hellraisin                  | 80,32,42    | 1    | true    | 407320        |
      | 2C3CDZBT9LH134135 | Brown                       | Sinamon Stick               | 50,34,18    | 1    | true    | 407320        |
      | 2C3CDZBT9LH134135 | Green                       | F8 Green                    | 74,76,52    | 1    | true    | 407320        |
      | 2C3CDZBT9LH134135 | Red                         | Torred Clearcoat            | 139,16,39   | 1    | true    | 407320        |
      | 2C3CDZBT9LH134135 | Red                         | Octane Red Pearlcoat        | 49,1,13     | 1    | true    | 407320        |
      | 2C3CDZBT9LH134135 | Silver                      | Triple Nickel Clearcoat     | 142,141,139 | 1    | true    | 407320        |
      | 2C3CDZBT9LH134135 | Orange                      | Go Mango                    | 228,26,34   | 1    | true    | 407320        |
      | 2C3CDZBT9LH134135 | White                       | White Knuckle Clearcoat     | 228,233,229 | 1    | true    | 407320        |
      | 2C3CDZBT9LH134135 | Black                       | Pitch Black Clearcoat       | 14,14,15    | 1    | true    | 407320        |
      | 2C3CDZBT9LH134135 | Dual Black R/T Side Stripes | Dual Black R/T Side Stripes |             | 3    |         | 407320        |
      | 2C3CDZBT9LH134135 | Dual Red R/T Side Stripes   | Dual Red R/T Side Stripes   |             | 3    |         | 407320        |
      | 2C3CDZBT9LH134135 | Dual White R/T Side Stripes | Dual White R/T Side Stripes |             | 3    |         | 407320        |

  Scenario Outline: Validate Roof Top and Stripe colors returned by vds in exterior colors array
    Given Actor wants to retrieve vin information for '<vin>'
    When Actor calls vds for vin
    Then Actor should see the '<genericDesc>', '<description>', '<rgbValue>', '<type>' and '<primary>' in exterior colors in service response for '<styles>'

  #Feature for VIN that have ECC 0085 Strip Color.
    Examples:
      | vin               | genericDesc           | description               | rgbValue    | type | primary | styles |
      | 2C3CDXL98JH155675 | Gray                  | Maximum Steel Metallic CC | 29,33,34    | 1    | true    | 393217 |
      | 2C3CDXL98JH155675 | Gray                  | Granite Pearlcoat         | 74,70,69    | 1    | true    | 393217 |
      | 2C3CDXL98JH155675 | Blue                  | Indigo Blue               | 38,85,155   | 1    | true    | 393217 |
      | 2C3CDXL98JH155675 | Gray                  | Destroyer Gray Clearcoat  | 93,93,93    | 1    | true    | 393217 |
      | 2C3CDXL98JH155675 | Green                 | F8 Green                  | 63,85,45    | 1    | true    | 393217 |
      | 2C3CDXL98JH155675 | Purple                | Plum Crazy Pearlcoat      | 57,52,115   | 1    | true    | 393217 |
      | 2C3CDXL98JH155675 | Blue                  | B5 Blue Pearlcoat         | 18,121,163  | 1    | true    | 393217 |
      | 2C3CDXL98JH155675 | Red                   | Torred Clearcoat          | 139,16,39   | 1    | true    | 393217 |
      | 2C3CDXL98JH155675 | Red                   | Octane Red Pearlcoat      | 49,1,13     | 1    | true    | 393217 |
      | 2C3CDXL98JH155675 | Red                   | Redline Red Tricoat Pearl | 106,0,18    | 1    | true    | 393217 |
      | 2C3CDXL98JH155675 | Silver                | Billet Clearcoat          | 130,134,136 | 1    | true    | 393217 |
      | 2C3CDXL98JH155675 | Orange                | Go Mango                  | 228,26,34   | 1    | true    | 393217 |
      | 2C3CDXL98JH155675 | White                 | White Knuckle Clearcoat   | 229,233,229 | 1    | true    | 393217 |
      | 2C3CDXL98JH155675 | Black                 | Pitch Black Clearcoat     | 14,14,15    | 1    | true    | 393217 |
      | 2C3CDXL98JH155675 | Yellow                | Yellow Jacket Clearcoat   | 206,167,0   | 1    | true    | 393217 |
      | 2C3CDXL98JH155675 | Dual Carbon Stripes   | Dual Carbon Stripes       |             | 3    |         | 393217 |
      | 2C3CDXL98JH155675 | Dual Gunmetal Stripes | Dual Gunmetal Stripes     |             | 3    |         | 393217 |
      | 2C3CDXL93KH526243 | Gray                  | Maximum Steel Metallic CC | 29,33,34    | 1    | true    | 401120 |
      | 2C3CDXL93KH526243 | Gray                  | Granite Pearlcoat         | 74,70,69    | 1    | true    | 401120 |
      | 2C3CDXL93KH526243 | Blue                  | Indigo Blue               | 38,85,155   | 1    | true    | 401120 |
      | 2C3CDXL93KH526243 | Gray                  | Destroyer Gray Clearcoat  | 93,93,93    | 1    | true    | 401120 |
      | 2C3CDXL93KH526243 | Green                 | Sublime Metallic CC       | 123,166,40  | 1    | true    | 401120 |
      | 2C3CDXL93KH526243 | Green                 | F8 Green                  | 63,85,45    | 1    | true    | 401120 |
      | 2C3CDXL93KH526243 | Purple                | Plum Crazy Pearlcoat      | 57,52,115   | 1    | true    | 401120 |
      | 2C3CDXL93KH526243 | Blue                  | B5 Blue Pearlcoat         | 18,121,163  | 1    | true    | 401120 |
      | 2C3CDXL93KH526243 | Red                   | Torred Clearcoat          | 139,16,39   | 1    | true    | 401120 |
      | 2C3CDXL93KH526243 | Red                   | Octane Red Pearlcoat      | 49,1,13     | 1    | true    | 401120 |
      | 2C3CDXL93KH526243 | Silver                | Triple Nickel Clearcoat   | 130,134,136 | 1    | true    | 401120 |
      | 2C3CDXL93KH526243 | Orange                | Go Mango                  | 228,26,34   | 1    | true    | 401120 |
      | 2C3CDXL93KH526243 | White                 | White Knuckle Clearcoat   | 229,233,229 | 1    | true    | 401120 |
      | 2C3CDXL93KH526243 | Black                 | Pitch Black Clearcoat     | 14,14,15    | 1    | true    | 401120 |
      | 2C3CDXL93KH526243 | Dual Blue Stripes     | Dual Blue Stripes         |             | 3    |         | 401120 |
      | 2C3CDXL93KH526243 | Dual Carbon Stripes   | Dual Carbon Stripes       |             | 3    |         | 401120 |
      | 2C3CDXL93KH526243 | Dual Gunmetal Stripes | Dual Gunmetal Stripes     |             | 3    |         | 401120 |
      | 2C3CDXL93KH526243 | Dual Red Stripes      | Dual Red Stripes          |             | 3    |         | 401120 |
      | 2C3CDXL93KH526243 | Dual Silver Stripes   | Dual Silver Stripes       |             | 3    |         | 401120 |


  Scenario Outline: Validate Roof Top and Stripe colors returned by vds in exterior colors array
    Given Actor wants to retrieve vin information for '<vin>'
    When Actor calls vds for vin
    Then Actor should see the '<genericDesc>', '<description>', '<rgbValue>', '<type>' and '<primary>' in exterior colors in service response for '<styles>'

  #Feature for VIN that have ECC 0088 Roof Color.
    Examples:
      | vin               | genericDesc        | description               | rgbValue    | type | primary | styles |
      | 2C3CDXHG9FH827550 | Blue               | B5 Blue Pearl Coat        | 24,58,114   | 1    | true    | 370245 |
      | 2C3CDXHG9FH827550 | Silver             | Billet Silver Metallic CC | 130,134,136 | 1    | true    | 370245 |
      | 2C3CDXHG9FH827550 | White              | Bright White Clearcoat    | 229,233,229 | 1    | true    | 370245 |
      | 2C3CDXHG9FH827550 | Gray               | Granite Crystal Met CC    | 53,54,56    | 1    | true    | 370245 |
      | 2C3CDXHG9FH827550 | Off-white          | Ivory Tri-Coat Pearl      | 200,199,192 | 1    | true    | 370245 |
      | 2C3CDXHG9FH827550 | Blue               | Jazz Blue Pearlcoat       | 3,13,27     | 1    | true    | 370245 |
      | 2C3CDXHG9FH827550 | Black              | Phantom Black TC Pearl    | 17,18,20    | 1    | true    | 370245 |
      | 2C3CDXHG9FH827550 | Black              | Pitch Black               | 14,15,13    | 1    | true    | 370245 |
      | 2C3CDXHG9FH827550 | Red                | Redline Red Tricoat Pearl | 106,0,18    | 1    | true    | 370245 |
      | 2C3CDXHG9FH827550 | Red                | Torred                    | 139,16,39   | 1    | true    | 370245 |
      | 2C3CDXHG9FH827550 | Black Painted Roof | Black Painted Roof        |             | 2    |         | 370245 |


  Scenario Outline: Validate Roof Top and Stripe colors returned by vds in exterior colors array
    Given Actor wants to retrieve vin information for '<vin>'
    When Actor calls vds for vin
    Then Actor should see the '<genericDesc>', '<description>', '<rgbValue>', '<type>' and '<primary>' in exterior colors in service response for '<styles>'

  #Feature for VIN that have ECC 0073 Roof Color with ICC HMA02.
    Examples:
      | vin               | genericDesc                   | description                   | rgbValue    | type | primary | styles |
      | SALGS2KF4GA298104 | Black                         | Santorini Black               | 25,26,28    | 1    | true    | 379586 |
      | SALGS2KF4GA298104 | White                         | Fuji White                    | 227,232,226 | 1    | true    | 379586 |
      | SALGS2KF4GA298104 | Silver                        | Indus Silver                  | 188,190,190 | 1    | true    | 379586 |
      | SALGS2KF4GA298104 | Blue                          | Loire Blue                    | 20,32,48    | 1    | true    | 379586 |
      | SALGS2KF4GA298104 | Green                         | Aintree Green                 | 18,41,35    | 1    | true    | 379586 |
      | SALGS2KF4GA298104 | Gray                          | Corris Grey                   | 92,95,93    | 1    | true    | 379586 |
      | SALGS2KF4GA298104 | Gray                          | Kaikoura Stone                | 73,65,53    | 1    | true    | 379586 |
      | SALGS2KF4GA298104 | Red                           | Firenze Red                   | 111,12,25   | 1    | true    | 379586 |
      | SALGS2KF4GA298104 | Red                           | Montalcino Red                | 88,9,28     | 1    | true    | 379586 |
      | SALGS2KF4GA298104 | Silver                        | Aleutian Silver               | 151,156,153 | 1    | true    | 379586 |
      | SALGS2KF4GA298104 | Gray                          | Scotia Grey                   | 89,95,90    | 1    | true    | 379586 |
      | SALGS2KF4GA298104 | White                         | Yulong White                  | 205,207,208 | 1    | true    | 379586 |
      | SALGS2KF4GA298104 | Black                         | Barolo Black                  | 26,22,21    | 1    | true    | 379586 |
      | SALGS2KF4GA298104 | Gray                          | Aruba                         | 132,127,124 | 1    | true    | 379586 |
      | SALGS2KF4GA298104 | Black                         | Mariana Black                 | 27,29,28    | 1    | true    | 379586 |
      | SALGS2KF4GA298104 | Gray                          | Waitomo Grey                  | 61,62,65    | 1    | true    | 379586 |
      | SALGS2KF4GA298104 | Gray                          | Carpathian Grey               | 46,45,48    | 1    | true    | 379586 |
      | SALGS2KF4GA298104 | Indus Silver Contrast Roof    | Indus Silver Contrast Roof    |             | 2    |         | 379586 |
      | SALGS2KF4GA298104 | Santorini Black Contrast Roof | Santorini Black Contrast Roof |             | 2    |         | 379586 |
      | 2FMHK6C82JBA18299 | Blue                          | Blue Metallic                 | 37,55,67    | 1    | true    | 393232 |
      | 2FMHK6C82JBA18299 | Black                         | Shadow Black                  | 10,10,12    | 1    | true    | 393232 |
      | 2FMHK6C82JBA18299 | Gold                          | White Gold Metallic           | 167,163,142 | 1    | true    | 393232 |
      | 2FMHK6C82JBA18299 | Gray                          | Magnetic Metallic             | 69,71,68    | 1    | true    | 393232 |
      | 2FMHK6C82JBA18299 | Red                           | Burgundy Velvet Tinted CC     | 48,2,5      | 1    | true    | 393232 |
      | 2FMHK6C82JBA18299 | Red                           | Ruby Red Met Tinted CC        | 87,5,18     | 1    | true    | 393232 |
      | 2FMHK6C82JBA18299 | White                         | White Platinum Met TC         | 210,206,206 | 1    | true    | 393232 |
      | 2FMHK6C82JBA18299 | Silver                        | Ingot Silver Metallic         | 161,161,161 | 1    | true    | 393232 |
      | 2FMHK6C82JBA18299 | White                         | Oxford White                  | 231,231,229 | 1    | true    | 393232 |
      | 2FMHK6C82JBA18299 | Monochromatic Roof            | Monochromatic Roof            |             | 2    |         | 393232 |
      | 2FMHK6C82JBA18299 | Shadow Black Painted Roof     | Shadow Black Painted Roof     |             | 2    |         | 393232 |


  Scenario Outline: Validate Roof Top and Stripe colors returned by vds in exterior colors array
    Given Actor wants to retrieve vin information for '<vin>'
    When Actor calls vds for vin
    Then Actor should see the '<genericDesc>', '<description>', '<rgbValue>', '<type>' and '<primary>' in exterior colors in service response for '<styles>'

  #Feature for VIN that have ECC 0102 Roof Color with ICC HMA02.
    Examples:
      | vin               | genericDesc                   | description                   | rgbValue    | type | primary | styles |
      | SALZJ2FX1LH036802 | Black                         | Narvik Black                  | 23,23,25    | 1    | true    | 404662 |
      | SALZJ2FX1LH036802 | White                         | Fuji White                    | 227,232,226 | 1    | true    | 404662 |
      | SALZJ2FX1LH036802 | Black                         | Santorini Black Metallic      | 25,26,28    | 1    | true    | 404662 |
      | SALZJ2FX1LH036802 | White                         | Yulong White Metallic         | 205,207,208 | 1    | true    | 404662 |
      | SALZJ2FX1LH036802 | Gray                          | Eiger Grey Metallic           | 91,92,86    | 1    | true    | 404662 |
      | SALZJ2FX1LH036802 | Gray                          | Corris Grey Metallic          | 74,73,73    | 1    | true    | 404662 |
      | SALZJ2FX1LH036802 | Silver                        | Indus Silver Metallic         | 188,190,190 | 1    | true    | 404662 |
      | SALZJ2FX1LH036802 | Red                           | Firenze Red Metallic          | 108,15,24   | 1    | true    | 404662 |
      | SALZJ2FX1LH036802 | Gray                          | Kaikoura Stone Metallic       | 94,82,72    | 1    | true    | 404662 |
      | SALZJ2FX1LH036802 | Silver                        | Seoul Pearl Silver Met        | 164,170,179 | 1    | true    | 404662 |
      | SALZJ2FX1LH036802 | Gray                          | Carpathian Grey Prem Met      | 42,42,44    | 1    | true    | 404662 |
      | SALZJ2FX1LH036802 | Silver                        | Silicon Silver Prem Met       | 120,117,109 | 1    | true    | 404662 |
      | SALZJ2FX1LH036802 | Black Contrast Roof           | Black Contrast Roof           |             | 2    |         | 404662 |
      | SALZJ2FX1LH036802 | Silver Contrast Roof          | Silver Contrast Roof          |             | 2    |         | 404662 |
      | SALVP2RX5JH295251 | White                         | Fuji White                    | 227,232,226 | 1    | true    | 397022,397023 |
      | SALVP2RX5JH295251 | Black                         | Narvik Black                  | 23,23,25    | 1    | true    | 397022,397023 |
      | SALVP2RX5JH295251 | Silver                        | Indus Silver Metallic         | 188,190,190 | 1    | true    | 397022,397023 |
      | SALVP2RX5JH295251 | Gray                          | Corris Gray Metallic          | 74,73,73    | 1    | true    | 397022,397023 |
      | SALVP2RX5JH295251 | Black                         | Santorini Black Metallic      | 25,26,28    | 1    | true    | 397022,397023 |
      | SALVP2RX5JH295251 | Blue                          | Loire Blue Metallic           | 20,32,48    | 1    | true    | 397022,397023 |
      | SALVP2RX5JH295251 | Gray                          | Kaikoura Stone Metallic       | 71,63,53    | 1    | true    | 397022,397023 |
      | SALVP2RX5JH295251 | Red                           | Firenze Red Metallic          | 108,15,24   | 1    | true    | 397022,397023 |
      | SALVP2RX5JH295251 | White                         | Yulong White Metallic         | 205,207,208 | 1    | true    | 397022,397023 |
      | SALVP2RX5JH295251 | Gray                          | Carpathian Grey Prem Met      | 42,42,44    | 1    | true    | 397022,397023 |
      | SALVP2RX5JH295251 | Silver                        | Silicon Silver Prem Met       | 120,117,109 | 1    | true    | 397022,397023 |
      | SALVP2RX5JH295251 | Black Contrast Roof           | Black Contrast Roof           |             | 2    |         | 397022,397023 |
      | SALVP2RX5JH295251 | Grey Contrast Roof            | Grey Contrast Roof            |             | 2    |         | 397022,397023 |
