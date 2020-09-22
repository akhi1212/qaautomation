Feature: Verify change in the business service gvwrLow to standardGVWR in vehicle info.

  Scenario Outline: Validate  gvwrLow to standardGVWR in vehicle info.
    Given user wants to retrieve vin information for '<vin>'
    When user calls vds for vin
    Then user should see the standardGVWR '<standardGVWR>' in service response

  ## style id should process : 398624,398336,324103,401491,358368,403545
    Examples:
      | vin               | standardGVWR |
      | 3GCPCREA8BG219721 | 6800         |
      | 1C6SRFPT5KN507815 | 6900         |
      | 5FPYK3F78KB000472 | 6019         |
      | 1GB3GSCG4K1157321 | 9900         |
      | WP0AA2A87EK172460 | 3627         |
      | 1FTFX1E54KFA26018 | 6500         |

