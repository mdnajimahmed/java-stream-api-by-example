# Collector
- Combination of 4 things:
  - `supplier` ( Returns a Supplier<A> providing a new, mutable result container.
    Example: For counting elements, the supplier might be () -> new AtomicInteger(0).)
  - `accumulator()` Returns a BiConsumer<A, T> folding a value of type T into the mutable result container of type A.
    Example: For summing integers, the accumulator could be (sum, element) -> sum += element.
  - `combiner()` Returns a BinaryOperator<A> combining two partial results into a single result.
    Example: For parallel streams, the combiner might merge two accumulators into one.
# Collectors.groupingBy

### Simple GroupingBy:
- just one parameter (it's called classifier)
- key is defined by the classifier function
- value is always List
- always return Map<K, List<T>>
- Example
```
Map<Integer, List<Purchase>> purchasesByYear = purchaseStream
.collect(Collectors.groupingBy(Purchase::getYear));
``` 
### GroupingBy with Downstream Collector:
- classifier + collector
- This overload allows you to apply a downstream collector to the elements of each group. It can be used to perform additional aggregation on the grouped elements.
- always return Map <K, D> - observe carefully, the value of the map can be a vector or a scalar.
- Example
```
Map<Integer, Double> totalSpentByYear = purchaseStream
.collect(Collectors.groupingBy(Purchase::getYear, Collectors.summingDouble(Purchase::getPrice)));
```

### GroupingBy with Supplier and Downstream Collector:
- classifier + supplier + downstream
- This overload provides more flexibility by allowing you to supply your own Map implementation (via the mapFactory parameter) and apply a downstream collector. It can be useful for creating a specific type of Map or for parallel processing.
- Example
```
TreeMap<Integer, Set<String>> itemsByYear = purchaseStream
        .collect(Collectors.groupingBy(Purchase::getYear, TreeMap::new, Collectors.mapping(Purchase::getItemId, Collectors.toSet())));
```