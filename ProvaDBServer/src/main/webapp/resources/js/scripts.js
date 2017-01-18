function verifica(xhr, status, args, dialogo){
    if(args.validationFailed){
        PF(dialogo).jq.effect('shake',{
            times: 5
        }, 100);
    }else{
        PF(dialogo).hide();        
    }
}