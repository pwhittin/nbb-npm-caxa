(ns nbb-npm-caxa.core
  (:require ["readline-sync" :as rls]
            ["sync-fetch$default" :as sf]))

(defn get-input [prompt]
  (rls/question prompt))

(defn get-password-input [prompt]
  (rls/question prompt #js {:hideEchoBack true}))

(defn base64-encode [in-string]
  (as-> in-string s
    (.from js/Buffer s)
    (.toString s "base64")))

(defn -main [& args]
  (let [url (get-input "Enter url: ") ; try entering "https://book.babashka.org"
        url-text (.text (sf url))
        ids (re-seq #"id=\"[^\"]*\"" url-text)]
    (println "There are" (count ids) "instances of id=\"")
    (doseq [id (take 5 ids)]
      (println id))))

;; (-main)
