(ns clojure-noob.factors)

(defn factor? [number r]
      (zero? (rem number r)))

(defn factors [number]
      (flatten (map #(list % (/ number %))
                    (filter #(factor? number %) (range 1 (Math/sqrt number)))))
      )

(defn sum-factors [number]
      (reduce + (factors number)))

(defn perfect-number? [number]
      (= number (- (sum-factors number) number))
      )
