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

(defn execute-instructions [start]
  (loop [i 0 state start]
    (let [[k x y opcode] (map #(state (+ i %)) [3 2 1 0])]
      (case opcode
        99 state
        1 (recur (+ i 4) (assoc state k (+ (state x) (state y))))
        2 (recur (+ i 4) (assoc state k (* (state x) (state y))))))))

(defn part-1 [start] ((execute-instructions start) 0))

(defn part-2 [start]
  (doseq [x (range 0 100) y (range 0 100)]
    (let [result (execute-instructions (assoc (assoc start 1 x) 2 y))]
      (if (= (result 0) 19690720)
        (println (+ y (* 100 x)))))))