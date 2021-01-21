(ns clojure-noob.core
    (:gen-class))

(defn my-loop []
      (loop [x 15]
            (when (> x 1)
                  (println x)
                  (recur (- x 2))))
      )


(defn -main
      "I don't do a whole lot ... yet."
      [& args]
      (println "Enter something> ")
      (let [x (read-line)]
           (println (str "You typed " x))
           )
      (my-loop)
      )
