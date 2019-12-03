; DAY 1 PART 1
(reduce + 
        (map #( - (int (/ % 3)) 2)
             (map #(Integer/parseInt %) 
                  (clojure.string/split (slurp "day1_input.txt") #"\s+")
                  )
             )
        )

; DAY 1 PART 2
(defn recurfuel [mass]
    (loop [totalfuel 0
           fuel (- (int (/ mass 3))2)]
      (if (<= fuel 0)
        totalfuel
    (recur (+ fuel totalfuel) (- (int (/ fuel 3))2))
                                   )))

(reduce +
        (map recurfuel
             (map #(Integer/parseInt %)
                  (clojure.string/split (slurp "day1_input.txt") #"\s+"))))

; DAY 2 PART 1
(defn getinput [input]
  (mapv #(Integer/parseInt %) (clojure.string/split (slurp input) #",")))

(defn computer [intcode] 
(doseq [code intcode]
  (if (= (mod (.indexOf intcode code) 4) 0) (println code) "other code")
  ))

(def input (getinput "day2_input.txt"))
(computer input)