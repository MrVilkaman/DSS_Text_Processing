package domain.usecase.core


import domain.providers.SchedulersDP

/**
 * Created by Zahar on 19.03.16.
 */
public abstract class LoadUseCase<T>(provider: SchedulersDP) : UseCase<T>(provider.io(), provider.mainThread())
