(ns cinephile.fixtures.cinephile)

(def wire-in {:customer-id "c789839b-dc7d-48ce-ada2-283c915d2321"
              :name        "Unit"
              :last-name   "McTest"
              :email       "unit.mctest@fakeflix.com"
              :password    "123456"})
(def model {:cinephile/customer-id #uuid "c789839b-dc7d-48ce-ada2-283c915d2321"
            :cinephile/name        "Unit"
            :cinephile/last-name   "McTest"
            :cinephile/email       "unit.mctest@fakeflix.com"
            :cinephile/password    "123456"})
