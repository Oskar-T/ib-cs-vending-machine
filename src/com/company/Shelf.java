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

public class Shelf {
  public Shelf () {
    final int NUM_PRODUCT_TYPES = 4;
    products = new Product [NUM_PRODUCT_TYPES];
    quantities = new int [NUM_PRODUCT_TYPES];
    
    products [0] = Product.Beverage;
    quantities [0] = 2;
    products [1] = Product.Apple;
    quantities [1] = 1;
    products[2] = Product.Banana;
    quantities[2] = 2;
    products[3] = Product.Chocolate;
    quantities[3] = 1;
  }

  // returns an array of products available (for which quantity is positive)
  public Product[] getAvailableProducts () {
    java.util.ArrayList<Product> availableProducts = new java.util.ArrayList<> ();
    for (int i = 0; i < products.length; i++)
      if (quantities [i] > 0)
        availableProducts.add (products [i]);

    return availableProducts.toArray (new Product [0]);
  }
  
  // returns true if there are no more products to be sold and false
  // otherwise
  public boolean isEmpty () {
    int counter = 0;
    for (int quantity : quantities) {
      if (quantity == 0) {
        counter++;
      }
    }
    return counter == quantities.length;
  }
  
  // dispenses a product (that is, in this simple app just decreases
  // its quantity by 1)
  public void dispense (Product product) {

    int id = 0;
    for (int i = 0; i < products.length; i++) {
      if(products[i] == product) {
        id = i;
      }
    }
    quantities[id]--;

  }
  
  Product[] products;
  int[] quantities;
}
