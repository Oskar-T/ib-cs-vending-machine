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

public class VendingMachine implements AutoCloseable
{
  public VendingMachine ()
  {
    this.shelf = new Shelf ();
    this.ui = new UserInterface ();
  }

  // application logic
  public void run () {
    while (!shelf.isEmpty ()) {
      Product[] availableProducts = shelf.getAvailableProducts ();
      Product purchasedProduct = ui.getChosenProduct (availableProducts);
      if (ui.verifyPayment (purchasedProduct))
        shelf.dispense (purchasedProduct);
    }
  }

  @Override
  public void close ()
  {
    if (ui != null)
      ui.close ();
  }

  private Shelf shelf;
  private UserInterface ui;
}
