(ns nbb-npm-caxa.core
  (:require [clojure.string :refer [split trim upper-case]]
            [goog.string :as gstring]
            [goog.string.format]
            ["readline-sync" :as rls]
            ["sync-fetch$default" :as sf]))

(defn format [fmt & args]
  (apply gstring/format fmt args))

(defn get-input [prompt]
  (rls/question prompt))

(defn get-password-input [prompt]
  (rls/question prompt #js {:hideEchoBack true}))

(defn base64-encode [in-string]
  (as-> in-string s
    (.from js/Buffer s)
    (.toString s "base64")))

(defn -main [& args]
;; try entering "https://book.babashka.org"
  (let [url (get-input "Enter url: ")
        url-text (.text (sf url))
        ids (re-seq #"id=\"[^\"]*\"" url-text)]
    (println (format "There are %4d instances of id=\"" (count ids)))
    (doseq [id (take 5 ids)]
      (println (-> id
                   (split #"\"")
                   second
                   trim
                   upper-case)))))

;; (-main)
