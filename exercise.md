# Easy:
- E01: Find the sum of all numbers in a list/array.
- E02: Filter out the even numbers from a list/array.
- E03: Double each element in a list/array.
- E04: Find the average of all numbers in a list/array.
- E05: Check if all elements in a list/array are greater than 10.
- E06: Count the number of strings in a list/array that start with a given prefix.
- E07: Convert a list/array of strings to uppercase.
- E08: Remove duplicate elements from a list/array(non-primitive type).
- E09: Sort a list/array of strings in alphabetical order.
- E10(Skipped): Check if any element in a list/array is divisible by 5.
- E11: find the highest purchase in the list, if there is a tie take the latest by year.
- E12: Concatenate all strings in a list/array into a single string.
- E13: Group purchases by year, and for each year group by users. output should be (year,user,List<purchase>) or Map<Integer,Map<String,List<Purchase>>>
- E14(Skipped): Calculate the product of all numbers in a list/array.
- E15(skipped): Find the length of the longest string in a list/array.
- E16: Partition a list/array of integers into even and odd numbers.
- E17(skipped): Check if a list/array contains a specific element.
- E18(skipped): Convert a list/array of integers to a list/array of their squares.
- E19: Find the second smallest number in a list/array.
- E20: Remove all strings from a list/array that have more than 5 characters.
- E21: Calculate the sum of the squares of all even numbers in a list/array.
- E22: Sort a list/array of strings by their length.
- E23: Find the average length of strings in a list/array.
- E24: Extract the first letter of each word in a list/array of strings.
- E25: Group a list/array of words by their length.
- E26: Find the maximum length of strings in a list/array.
- E27: Check if all strings in a list/array are palindrome.
- E28: Count the number of words in a list/array of sentences.
- E29: Find the difference between the largest and smallest numbers in a list/array.
- E30: Sort a list/array of strings by their last character.

# Medium:

Given
```
public class Purchase {
    public Purchase(String userId, String itemId, int year, double price) {
        this.userId = userId;
        this.itemId = itemId;
        this.year = year;
        this.price = price;
    }
}
```

```
public class Address {
    public Address(String userId, String city, String country) {
        this.userId = userId;
        this.city = city;
        this.country = country;
    }
}
```
# Phase 01:
- Write a Java Stream operation that combines the information from purchases and addresses into a single map. The map should have userId as the key and a PurchaseWithAddress object as the value. The PurchaseWithAddress class should contain combined information from the Purchase and Address classes.
  First Overload:
  Use the toMap collector with a merge function to handle duplicate keys.
  Second Overload:
  Use the toMap collector with a provided map supplier.
  Third Overload:
  Use the toMap collector with a merge function and a map supplier.
- averaging int/double/long returns double, but takes int,double,long respectively
- counting : returns long
- Filter and Collect Purchases by Year *** (Grouping then filtering)
- ```
  purchases.stream()
                .collect(Collectors.groupingBy(Purchase::getYear,
                        Collectors.filtering(p -> p.getYear() == targetYear, Collectors.toList())));
  ```

-  asd


# Phase 02:
- Group purchases by user: Use Collectors.groupingBy to group purchases by the userId.
- Calculate the total price for each user: Use Collectors.groupingBy and Collectors.summingDouble to find the total price for each user.
- Find the average price of items: Use Collectors.averagingDouble to calculate the average price of all items.
- Group items by year and find the average price for each year: Use Collectors.groupingBy and Collectors.averagingDouble to find the average price for each year.
- Join item names for each user: Use Collectors.groupingBy and Collectors.mapping to join item names for each user using Collectors.joining.
- Find the highest priced item for each user: Use Collectors.groupingBy and Collectors.collectingAndThen with Collectors.maxBy to find the highest priced item for each user.
- Summarize prices for each item: Use Collectors.groupingBy and Collectors.summarizingDouble to get statistics (count, sum, min, average, max) for the prices of each item.
- Partition items into expensive and non-expensive (price > 100):Use Collectors.partitioningBy to partition items into expensive and non-expensive based on the price.
- Calculate the total sum of prices for all items:Use Collectors.summingDouble to find the total sum of all prices.
- Calculate the total sum of prices for each year: Use Collectors.groupingBy and Collectors.summingDouble to find the total sum of prices for each year.
- Teeing Two Collectors: Collect purchases into a list and simultaneously calculate their total price: List<Purchase> allPurchases; double totalPrice; Map<String, Object> results = purchases.stream().collect(Collectors.teeing(Collectors.toList(), Collectors.summingDouble(Purchase::getPrice), (list, total) -> { allPurchases = list; totalPrice = total; return results; }));
- Custom Collector for Summary Statistics: Create a custom collector to calculate summary statistics (min, max, average, count) of purchase prices: Collector<Purchase, ?, IntSummaryStatistics> summaryStatsCollector = Collectors.summarizingInt(Purchase::getPrice); IntSummaryStatistics stats = purchases.stream().collect(summaryStatsCollector);
- Given a list of cities, find which city does not have any purchase yet.
- find which city has most purchase
- for each country find the city with most purchase amount.
- for each country find the city with most item sold.
- for each country find the list of cities that has sales between (X and Y).
- find the location of each purchase
- for each location, list all purchases
- find the distinct item sold in each city
- for each year, find the max spent by any user
- for each year, average spent by any user
- for each year, find those users that made at least two transactions
- for each year, find those purchases made in following cities - ["Alaska","Kuala Lumpur","Dhaka"]
- Make a distinct list address by userid , if there is a tie take the latest one based on (lastUpdatedAt)
