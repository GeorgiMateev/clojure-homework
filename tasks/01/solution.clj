(defn digits [n]
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
(densities [0])

(defn index-by [f xs]
  nil)

(defn harmonic [n]
  nil)

(defn uniquify [in]
  nil)
