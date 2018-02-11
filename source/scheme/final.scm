(define avg (lambda (x)
   (/
	(apply +
		(map string->number (regexp-split #rx"," x))
	)
        (length (regexp-split #rx"," x))
   )	
 )
)
