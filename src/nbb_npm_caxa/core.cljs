(ns nbb-npm-caxa.core
  (:require ["readline-sync" :as rls]))

(defn get-input [prompt]
  (rls/question prompt))

(defn get-password-input [prompt]
  (rls/question prompt #js {:hideEchoBack true}))

(defn -main [& args]
  (let [url (get-input "Enter url: ")] ; try entering "https://book.babashka.org"
    (println "The url is:" url)))

;; (-main)
