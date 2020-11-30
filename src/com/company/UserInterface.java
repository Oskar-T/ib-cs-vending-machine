// Copyright (C) 2020 Jarmo Hurri

// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.

// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <https://www.gnu.org/licenses/>.

package com.company;

import java.util.Scanner;

public class UserInterface implements AutoCloseable
{
  public UserInterface ()
  {
    scanner = new Scanner (System.in);
  }

  // needed for implementation of AutoCloseable
  @Override
  public void close ()
  {
    if (scanner != null)
      scanner.close ();
  }

  // returns the product chosen by the customer
  public Product getChosenProduct (Product[] availableProducts)
  {
    System.out.println ("Available products:");
    for (int i = 0; i < availableProducts.length; i++)
      System.out.println ("id " + i + ": " + availableProducts [i]);

    Product chosenProduct = null;
    while (chosenProduct == null)
    {
      System.out.print ("Give id of chosen item and press enter: ");
      System.out.flush ();
      if (scanner.hasNextInt ())
      {
        int id = scanner.nextInt ();
        if (id >= 0 && id < availableProducts.length)
          chosenProduct =  availableProducts [id];
      }

      scanner.nextLine ();
    }

    return chosenProduct;
  }

  // returns true if the customer verifies payment and false otherwise
  public boolean verifyPayment (Product product)
  {
    System.out.println("Type the name of the product to confirm");
    System.out.flush ();
    String str = scanner.nextLine();
    return str.equals(product.toString());
  }
  
  private Scanner scanner;
}
