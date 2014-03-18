(use 'clojure.string)

(defn make-collection [input]
  (vec (for [song (split-lines input)
        :let [parts (map trim (split song #"\s*\.\s*"))
              genres (map trim (split (nth parts 2) #"\s*,\s*"))]]
        {:title (first parts)
         :artist (second parts)
         :genre (first genres)
         :subgenre (second genres)
         :tags (->>
                   (-> (if  (= (count parts) 4)
                         (nth parts 3)
                         "")
                       (split #"\s*,\s*")
                       (clojure.set/union genres))
                   (filter #(not (empty? %)))
                   (map lower-case)
                   (map keyword)
                   (into #{}))

         }
    )))


(defn match
  ([song [head & tail]]
   ((cond
     (= head :not)
       ((not (match song tail)))
     (= head :and)
       (and (for [crit tail]
              (match song tail)))
     (= head :or)
       (or (for [crit tail]
             (match song tail))))))
  ([song {tag :tag :keys [criterions]}]
   (and (contains? (song :tags) tag)
        (match song criterions)
        (map (fn [c]
               (= (song (first c))
                  (second c))) criterions))))

(defn search [collection field criteria]
  (filter #(not (nil? %)) (set (for [song collection
        :when (match song criteria)]
    (song field)))))

;(def in
 ; "My Favourite Things.          John Coltrane.      Jazz, Bebop.        popular, cover
  ;Alabama.                      John Coltrane.      Jazz, Avantgarde.
  ;Boplicity.                    Miles Davis.        Jazz, Bebop
  ;Autumn Leaves.                Bill Evans.         Jazz.               popular
  ;Waltz for Debbie.             Bill Evans.         Jazz
  ;Pathetique.                   Beethoven.          Classical
  ;Fur Elise.                    Beethoven.          Classical.          popular
  ;Toccata e Fuga.               Bach.               Classical, Baroque.
  ;Eine Kleine Nachtmusik.       Mozart.             Classical.          violin, fancy")

;(search (make-collection in) :subgenre {:genre "pop"})
