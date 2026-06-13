(ns template-cljfx.ui.root
  "Top-level cljfx component and state atom."
  (:require
   [cljfx.api :as fx]
   [template-cljfx.law.ui-schema :as schema]
   [malli.core :as m]))

(def state
  (atom {:title "cljfx Template"
         :count 0}))

(defn root-view
  "Root scene description. Pure function over app state."
  [{:keys [title count]}]
  {:pre [(m/validate schema/AppState {:title title :count count})]}
  {:fx/type  :stage
   :showing  true
   :title    title
   :scene    {:fx/type  :scene
               :root     {:fx/type  :v-box
                          :spacing  12
                          :padding  {:top 24 :right 24 :bottom 24 :left 24}
                          :children [{:fx/type :label
                                      :text    (str "Count: " count)}
                                     {:fx/type   :button
                                      :text      "Increment"
                                      :on-action (fn [_]
                                                   (swap! state update :count inc))}]}}})
