(defn digits [n]
<<<<<<< HEAD
  (if (= n 0) [0]
    (loop [result [] number n]
      (if (zero? number)
        (reverse result)
        (recur (conj result (mod number 10)) (int (/ number 10)))))))

;;(defn primes n
;;  (let [result (repeat n true)]
;;    (loop [i 2]
;;      (if (<= i (.sqrt n))
;;        (if (nth result i)
;;         (loop [j (pow i 2)]
;;            (if (<= j n) ((assoc result j false)
;;                          (recur ))))
;;       result))))

(defn prime-factors [n]
  nil)

(defn fizzbuzz [n]
  (if (= n 0) [0]
    (loop [x 1 result []]
      (if (> x n) result
      (recur (inc x) (conj result
                           (cond
                            (and (integer? (/ x 3)) (integer? (/ x 5))) "fizzbuzz"
                            (integer? (/ x 3)) "fizz"
                            (integer? (/ x 5)) "buzz"
                            :else x)))))))

(defn densities [xs]
  (map (fn [x]
         (loop [i 0 c 0]
           (if (= i (count xs)) c
             (recur (inc i)
                    (if (= (nth xs i) x)
                      (inc c)
                      c))))) xs))

(defn index-by [f xs]
  (apply merge (for [x xs]
    {(f x) x})))

(defn harmonic [n]
  nil)

(defn uniquify [in]
  (loop [i 0 counters {} result []]
     (if (< i (count in))
      (let [x (nth in i) value (counters x)]
          (recur
           (inc i)
           (if (nil? value)
            (assoc counters x 1)
            (assoc counters x (inc value)))
           (conj result
                 (if (nil? value)
                   x
                   (str x \- value)))))
       result)))
=======
  (loop [n n
         digits []]
    (let [digit (rem n 10)
          remaining (quot n 10)
          new-digits (conj digits digit)]
      (if (zero? remaining)
        (reverse new-digits)
        (recur remaining new-digits)))))

(defn prime-factors [n]
  (loop [n n
         i 2
         factors []]
    (cond (= n 1) factors
          (zero? (rem n i)) (recur (/ n i) i (conj factors i))
          :else (recur n (inc i) factors))))

(defn divides? [a b]
  (zero? (rem a b)))

(defn fizzbuzz [n]
  (for [i (range 1 (inc n))]
    (cond (divides? i 15) "fizzbuzz"
          (divides? i 5) "buzz"
          (divides? i 3) "fizz"
          :else i)))

(defn densities [xs]
  (map (frequencies xs) xs))

(defn index-by [f xs]
  (reduce #(assoc %1 (f %2) %2)
          {}
          xs))

(defn harmonic [n]
  (->> (inc n)
       (range 1)
       (map #(/ 1 %))
       (reduce +)))

(defn uniquify [coll]
  (reduce
   (fn [xs s]
     (loop [n 1
            c s]
       (if (some #{c} xs)
         (recur (inc n) (str s "-" n))
         (conj xs c))))
   []
   coll))
>>>>>>> upstream/master
