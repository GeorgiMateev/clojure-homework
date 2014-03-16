(def relations {
                #{:scissors :paper} [:scissors :cut :paper],
                #{:paper :rock} [:paper :covers :rock],
                #{:rock :lizard} [:rock :crushes :lizard],
                #{:lizard :spock} [:lizard :posions :spock],
                #{:spock :scissors} [:spock :smashes :scissors],
                #{:scissors :lizard} [:scissors :decapitate :lizard],
                #{:lizard :paper} [:lizard :eats :paper],
                #{:paper :spock} [:paper :disproves :spock],
                #{:spock :rock} [:spock :vaporizes :rock],
                #{:rock :scissors} [:rock :crusshes :scissors]
                 })

(defn fight [p1 p2]
  (if (nil? (relations #{p1 p2})) nil
    (relations #{p1 p2})))
